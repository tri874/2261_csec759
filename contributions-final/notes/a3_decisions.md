# Assignment 3: technical decisions and change record

Dated record of the design and debugging decisions behind the prototype
(James Southcott and Tri Tran, with Claude; see `ai-use.md`). Code pointers are
to EvoMaster v6.2.0 with our patches applied.

## D1 (2026-10-20) Integrate the rules into EvoMaster instead of a post-processor

**Options.** (a) Change EvoMaster's security phase and oracle; (b) the A2
plan's fallback: an external script that reads `report.json` and the generated
tests, replays each candidate with varied credentials, and reclassifies.

**Decision: (a).** The oracle already runs inside the fitness function on
tests built by `RestSecurityBuilder.handleNotRecognizedAuthenticated`, so the
replays can be appended to the very test that is evaluated, with EvoMaster's own
auth handling (login cookies, fixed headers). The replays then appear in the
generated test as evidence, and baseline and prototype differ only by the
patch (same version, same options; `forkoff` checks our build). (b) would have
had to re-implement WebGoat's cookie login and EvoMaster's header overriding.

**Consequence.** Requires building EvoMaster (`scripts/a3_build_fork.sh`, Maven
in Docker); the build and EvoMaster's own tests passed on the first attempt
(`raw/a3/orchestrator_logs/a3_build.log`, `raw/a3/build/tests_status.txt`).

## D2 (2026-10-20) Replays are copies; "identical request" = same signature

**Problem.** Rule 1 and Rule 2 need "the identical request with credentials
removed or swapped". **Decision.** The builder appends copies of Y and X
(`addNotRecognizedReplays`) and changes only `auth`; the oracle matches them by
`requestSignature` (verb, path template and the raw value of every parameter,
including schema headers such as `Authorization`, excluding EvoMaster's
configured auth). Copies, not regenerated requests, so the inputs are
byte-identical. **Assumption.** Black-box only: we do not call
`forceNewTaints()` on the copies (as the 403 expansion does), because new taint
values would change the signature; taint values only exist in white-box runs.
**Check.** Smoke run (`raw/a3_smoke/`): the replays appear as the last calls of
the K and H1 tests with the expected statuses (K: Y without credentials 401, X
as BAR 204; H1: X as BAR 401).

## D3 (2026-10-21) H2: tests lost because a replay was marked "stopping"

**Observation (pilot, v1).** H2 proto: the role-restricted fault appeared in
950 in run 1 only (`derived/a3_summary.md`), although the prototype's log line
showed 4 constructed, unconfirmed tests in each of the 3 runs
(`raw/a3/proto/H2/run_*/evomaster_stdout.log`). Prediction was 3/3.

**Hypotheses.** (H-a) The constructed tests no longer satisfy the original
precondition when re-executed (state changed, e.g. the evidence 403 became
200). (H-b) The tests show the fault but the archive rejects them. (H-c) Our
bookkeeping stops trying after a rejected test. The raw output could not
separate them: the rejected tests are not written.

**Test.** A logging-only patch (`patches/evomaster-a3-diagnostics.patch`,
commit `d6d14cf`) prints, for each constructed test, the executed calls with
user and status, the detected codes, and whether the archive kept it. Rerun:
proto on H2 and H1, 3 runs each (`raw/a3_diag/`). Example line (H2, run 2):

```
A3-DIAG X=DELETE:/api/admin/cache user=FOO Y=PUT:/api/resources/{id} codes=[109,202]
  decision=unconfirmed archived=false calls: PUT /api/resources/94 [FOO] -> 403 ;
  PUT /api/resources/30 [FOO] -> 204 ; DELETE /api/admin/cache [FOO] -> 401 ;
  PUT /api/resources/30 [NoAuth] -> 401 STOPPING
A3-DIAG X=DELETE:/api/admin/cache user=FOO Y=GET:/api/resources/{id} codes=[109,202,950]
  decision=unconfirmed archived=not-tried calls: ...
```

**Result.** H-a rejected: the evidence calls kept their statuses (403, 204/200).
Two bugs in our builder code, both confirmed in all 3 runs:

1. When Y is a PUT, EvoMaster has set its "save the Location header" flag
   (`RestCallAction.saveCreatedResourceLocation`). Our copy kept it, so the
   expected 401 of the anonymous replay made `AbstractRestFitness.handleSaveLocation`
   mark the result `stopping`, and the oracle (`RestSecurityOracle.handleNotRecognizedAuthenticated`,
   unchanged upstream code) skips any test with a stopping call: codes without
   305/950, nothing new for the archive (`archived=false`).
2. `keptUnconfirmed` was set even when the archive rejected the test, so the
   GET-based tests, which did show 950, were never offered (`not-tried`). In
   run 1, user FOO happened to try GET first, which explains the 1/3.

**Fix** (`patches/evomaster-a3-fix-replay-stopping.patch`): clear
`saveCreatedResourceLocation` on both kinds of replay; set `keptUnconfirmed`
only when the test shows 950 and `addIfNeeded` returned true. The rules'
decisions are unchanged. **Alternative explanation still open:** none for H2;
the fix is checked by rerunning every prototype item as v2 (`raw/a3_v2/`,
predictions in the addendum of `a3_predictions.md`).

**Why the other cases were not affected in v1.** In K, H1, H1c and H4 the
constructed tests with a GET as evidence were offered to the archive first, or
a confirmed test ended the search, so every expected 305/950 report appeared in
3/3 runs; on P and C-alt every candidate endpoint also reached 950 in 3/3 runs.
Whether some v1 tests there were lost the same way is checked by the v2 rerun. v1 results are kept as the pilot of
record for v1, and v2 is reported next to them.

**v2 result (2026-10-21, `raw/a3_v2/`, 39 runs, all exit 0).** All v2
predictions held (`a3_predictions.md` addendum): H2 shows 950 in 3/3 runs; all
12 constructed H2 tests carry code 950; no replay is marked `STOPPING` in any
v2 run; every other confirmed/unconfirmed set equals v1
(`derived/a3_summary_a3_v2.md`). `archived=false` still occurs (2 of 12 on H2)
when an equally short test already holds the 950 target; the builder then
offers the next test, as intended. EvoMaster's affected tests pass on v2
(`raw/a3_v2/build/tests_status.txt`). Decision: keep the fix; v2 is the
prototype for the final evaluation.
