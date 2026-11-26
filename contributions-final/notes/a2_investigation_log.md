# Assignment 2 investigation log

Compiled on 2026-10-02 from the git history (commit hashes below) and the
run records in `raw/`. All times are UTC (the VM's clock is UTC; commit times
are shown converted from EDT, UTC−4). Predictions were written and committed
before the runs they predict; nothing here is backdated.

## Timeline

| When (UTC) | What | Evidence |
|---|---|---|
| 2026-09-14 04:17 | A1 reproduction committed (EvoMaster 6.1.1, 10 × 2 min) | commit `11f8ff0` |
| 2026-10-01 ~03:11–05:49 | A1 runs found invalid: every request went to `/WebGoat/WebGoat/...`, 0 of 204 endpoints returned 2xx. Run script fixed (target URL, login endpoint, 1 h budget, version records) | `raw/pre_fix/`, commits `10070d5`, `1d7e07d`, `dcbaa48`, `729337f` |
| 2026-10-01 05:33 | Smoke run after the fix: 168/204 endpoints 2xx; Not-Recognized 5 | `raw/smoke/` |
| 2026-10-01 05:50–16:09 | Valid A1 baseline: 10 × 1 h, EvoMaster 6.2.0. Not-Recognized 5.0 (same 5 endpoints every run), Leakage 0, Missed-Check 0 | `raw/webgoat/`, commit `b94635d` |
| 2026-10-01 (after the baseline) | Looked for a failure family (section below). Wrote the A2 plan (`ASSIGNMENT2_PLAN.md`, since folded into `notes/a2_session_summary.md`) | commit `3b4ef9b` (20:53) |
| 2026-10-01 21:01 | Predictions for K, P, C, C-alt, V and the replays committed | commit `6236406` |
| 2026-10-01 21:05 | A2 code committed (case K, configs, scripts) | commit `e151266` |
| 2026-10-01 21:10–21:24 | Pilot, 1 × 2 min per case (setup check) | `raw/a2_pilot/`, `raw/a2/orchestrator_logs/a2_pilot.log` |
| 2026-10-01 21:26 | Pilot fixes committed (K schema, automatic control rule, evidence listing) | commit `06c664c` |
| 2026-10-01 22:16–23:24 | Full run: K, P, C-alt, V (3 × 5 min each), replays, table | `raw/a2/`, `raw/a2/orchestrator_logs/a2_full.log` |
| 2026-10-01 23:31 | V2 prediction committed (before V2 ran) | commit `d16bb5e` |
| 2026-10-01 23:55–2026-10-02 00:11 | V2: 3 × 5 min | `raw/a2/V2/`, `raw/a2/orchestrator_logs/a2_v2.log` |
| 2026-10-02 00:29–00:33 | Results pushed; results write-up | commits `fd961c3`, `d8ed214` |

## How the failure family was found

Observations on the valid A1 baseline (`raw/webgoat/`), all 10 runs:

1. Of about 9,800 responses in the generated tests, none was a 403. Requests
   without a session always got 302 (3,414 times), never 401.
2. All 195 responses with status 401 went to logged-in users, on
   `/WebGoat/JWT/` endpoints only.
3. The 5 Not-Recognized reports were the same 5 JWT endpoints in all 10
   runs. Their call sequences (e.g. `raw/webgoat/run_1/EvoMaster_2_faults_Test.kt`,
   `test_111`–`test_114`) used, as evidence, a 401 and a 200 from the same user
   on the same endpoint with different inputs (`?user=EMF…` vs `?user=`; no
   `Authorization` header vs a junk one).
4. WebGoat's source (JWT lesson, `main` branch) explains every one of the
   401s by a lesson-level credential or lesson login, never the WebGoat
   session. Neither source file changed after 2026-06-20 (commit `7533e971ef`).
5. EvoMaster v6.2.0 `RestSecurityOracle.kt` (`hasNotRecognizedAuthenticated`,
   lines 556–605): the evidence may come from the same user and any inputs,
   and Y = X is not excluded (the paper requires Y ≠ X).

Directions considered and not chosen: Leakage and
Missed-Check never applicable on WebGoat (no 403s); plain BOLA in the IDOR
lesson (outside the paper's stated scope); the Schema-count gap (not a
security property).

## Decisions

**D1. Failure family: credential misattribution in the Not-Recognized
oracle.** Chosen because it concerns a claim the paper makes (its own oracle
definition), occurs on the A1 target (all 5 of WebGoat's reports), has
ground truth in source code, and suggests a concrete A3 change.

**D2. Focus and budget: `--endpointPrefix /JWT`, 5 min, 3 seeds.** The A1
2-minute smoke run and 1-hour runs both reported the same 5 endpoints, so a
short focused budget reaches the behavior. Check: P reproduced the same 5
endpoints in 3/3 runs.

**D3. Keep K, ported to Python.** WebGoat has no known true Not-Recognized
fault, so a positive control was needed to show the oracle path works. Port
validity check: K reported in 3/3 runs, replays R7a–c matched.

**D4. Control C → C-alt.** Rule written before any run
(`notes/a2_predictions.md`, commit `6236406`): try the lesson cookie; if no vote call
returns 202 in the pilot, switch to the Authorization-header version. Pilot
result: the vote endpoint was still reported and no vote call returned 202,
while replay R4 shows the same token works with curl. The full run applied the
rule automatically and logged the decision (first line of `a2_full.log`). This
ruled out using the cookie route with EvoMaster 6.2.0's fixed-header
mechanism; it did not test the cookie route any other way.

**D5. V's outcome → add V2.** V's main prediction (3 reports disappear)
failed; the alternative recorded with it held: `refresh/checkout` supplied
the evidence in all 10 Not-Recognized tests. This ruled out the narrower
explanation "the false alarms depend on `votings/login`". V2 (prediction
committed before it ran) removed both evidence endpoints: no reports in 3/3
runs while the 401s remained.

**D6. Refine the A3 rule: do not count a 302 redirect as evidence.** The
plan's first version of rule 1 counted a login redirect as "requires a login".
V2 shows the current oracle stays silent on WebGoat because 302 is not
evidence; counting it would validate every WebGoat session and let the
X-side false alarms through. Revised version: `notes/a2_session_summary.md` §8 and `notes/a3_plan.md` §2.

## Remaining uncertainty

- Whether the paper's 5 WebGoat faults are these 5 endpoints: the paper does
  not list them. The 401 logic is unchanged since at least Feb 2025, which
  makes it likely but unconfirmed. An experiment with the EvoMaster version
  used in the paper (if the authors can identify it) would settle it.
- Generality beyond WebGoat: only one real target. A3's constructed cases
  (an API whose main login also answers 401, plus a second credential) and
  another API with layered credentials would test it.
