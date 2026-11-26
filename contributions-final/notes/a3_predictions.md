# Assignment 3 predictions (written and committed before any A3 run)

Date: 2026-10-20. Prototype: EvoMaster v6.2.0 + `patches/evomaster-v6.2.0-a3.patch`
(Rule 1 = `--notRecognizedCredentialEvidence`, Rule 2 = `--notRecognizedUserAttribution`).
Cases and expected results: `cases/README.md`. Run plan: `scripts/a3_run_all.sh`.
Scoring: `scripts/a3_table.py` (confirmed = endpoints with code 305, unconfirmed =
code 950 only, per run, deduplicated by endpoint).

Nothing in the patch was changed after seeing any A3 result when this file was
committed. If the patch must change (e.g. a compile error), the change and its
reason go into `notes/a3_decisions.md`, and these predictions stay as written.

## Expected results (ground truth, independent of EvoMaster)

| Case | Expected Not-Recognized faults | Basis |
|---|---|---|
| P | none | A2: source of the JWT lesson, RFC 9110 §15.5.2, replays R1–R6 |
| C-alt | none | as P |
| K | `POST /api/resources/` (FOO) | by construction (port of EvoMaster's own test app), replay R7 |
| H1 | none | the vault's 401 is caused by the API key (same 401 for BAR; FOO gets 204 with the key): replays H1-1..5 |
| H1c | `POST /api/vault` (FOO) | FOO is recognized elsewhere, gets 401 with any key, BAR gets 204: replays H1c-1..4 |
| H2 | `DELETE /api/admin/cache` | both recognized users get 401 where 403 is correct: replays H2-1..4 |
| H4 | none | ZED's credentials are invalid, so its 401s are correct: replays H4-1..5 |

## Predicted EvoMaster output (confirmed 305 reports; "in 3/3 runs" unless noted)

| Case | baseline (official 6.2.0) | proto (both rules) | rule1 only | rule2 only | forkoff |
|---|---|---|---|---|---|
| P | the 5 JWT endpoints (A2) | none; the 5 move to 950 | none | none | as baseline |
| C-alt | 4 endpoints, not `refresh/checkout` (A2) | none; the 4 move to 950 | — | — | — |
| K | `POST /api/resources/` | `POST /api/resources/` (kept) | — | — | as baseline |
| H1 | `POST /api/vault` (false alarm) | none; vault in 950 | `POST /api/vault` (false alarm stays: the login evidence is genuine) | none | — |
| H1c | `POST /api/vault` | `POST /api/vault` (kept) | — | — | — |
| H2 | `DELETE /api/admin/cache` | none; cache in 950 (**predicted recall loss**: Rule 2 cannot tell "no configured user may call it" from "the 401 is not about the user") | — | — | — |
| H4 | `PUT` and `GET /api/resources/{id}` for ZED (2 false alarms) | none; both in 950 | none | both (false alarms stay: FOO gets non-401, so Rule 2 attributes the 401 to ZED) | — |

Mechanism predictions behind the table:

- WebGoat (P, C-alt): Rule 1 never finds evidence, because WebGoat answers 302
  (redirect to login), not 401/403, to a request without a session. So on
  WebGoat the prototype would also downgrade a true fault; this is the stated
  condition under which Rule 1 does not help (it needs an API that answers
  401/403 to anonymous requests).
- Rule 2 on P: userB gets the same 401 as userA on all 5 endpoints (identical
  inputs; the 401s depend on the lesson's cookie, header, body or query).
- The ablation separates the rules: H1 needs Rule 2 (Rule 1 alone keeps the
  false alarm), H4 needs Rule 1 (Rule 2 alone keeps the false alarms); on P
  each rule alone is enough.

## Cost predictions

- Security phase (`Phase SECURITY lasted`): on P, longer for proto than
  baseline (A2 baseline: 5–9 s), because each candidate gets 2 replay calls and
  the builder tries every evidence endpoint when a test is not confirmed.
  Possibly up to the phase's time box (10% of 5 min = 30 s); if the time box is
  hit, some candidates are not checked and that is reported as a timeout, not
  as a result. Synthetic cases: about 1 s in both.
- Replay calls (prototype log line): 2 per constructed test with both rules
  (1 for Rule 1, 1 for Rule 2 with two users); on P tens up to about 200; on
  the synthetic cases fewer than 20.
- Total HTTP calls (`evaluatedActions`) and elapsed time: no visible
  difference; the search phase dominates and has the same budget.
- Other oracles (codes other than 305/950): same codes and counts within the
  baseline's run-to-run variation.

## What would contradict the explanation

- K or H1c not confirmed by proto (unexpected recall loss beyond H2).
- A confirmed 305 left on P or C-alt under proto, rule1 or rule2.
- rule1 removing the H1 false alarm, or rule2 removing the H4 false alarms
  (then the rules do not act through the mechanism described).
- forkoff differing from baseline on P or K (then our build, not the rules,
  changes the output).

## Addendum, 2026-10-21: predictions for prototype v2 (written before any v2 run)

v2 = v1 + `patches/evomaster-a3-diagnostics.patch` (logging only) +
`patches/evomaster-a3-fix-replay-stopping.patch` (decision D3 in
`notes/a3_decisions.md`: replays no longer keep the "save location" flag, and
an unconfirmed test only counts as kept when it shows code 950 and the archive
accepted it). Baseline runs are not repeated (the baseline did not change).
v2 reruns every prototype item of the pilot (proto on all 7 cases, rule1 and
rule2 on H1, H4 and P) with the same seeds and budgets, into `raw/a3_v2/`.

| Item | v1 observed | v2 prediction |
|---|---|---|
| H2 proto | no 305; `DELETE /api/admin/cache` in 950 in 1/3 runs | no 305; `DELETE /api/admin/cache` in 950 in 3/3 runs (still a recall loss for confirmed faults) |
| every other item | see `derived/a3_summary.md` | same confirmed (305) sets in 3/3 runs as v1; the same or more endpoints in 950 |

Cost: replay calls per run of the same order as v1 (2 per constructed test
with both rules); the `A3-DIAG` log lines show, for each constructed test, the
calls, the codes and whether the archive kept it.

**Outcome (added after the v2 runs, 2026-10-21):** all v2 predictions held
(`derived/a3_summary_a3_v2.md`).
