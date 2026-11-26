# Case C-alt: matched control (Authorization header)

**One factor changed vs P:** the auth config. Both users also send
`Authorization: Bearer a2-control`, the credential `POST /JWT/refresh/checkout`
checks for. Everything else (WebGoat image, users, schema, EvoMaster image and
options, seeds, budget) is identical to P.

Input: `environment/config/webgoat-em-c-auth.yaml`; diff vs P's config:
[`auth-config.diff`](auth-config.diff); the copy used by the runs:
`raw/a2/C-alt/auth-config.yaml`. Command: `CONTROL=auth STEPS="C" scripts/a2_run_all.sh`.

**Why this version.** It is the plan's pre-registered fallback for C (see
`../C_cookie_not_used/`). The pilot showed that EvoMaster 6.2.0 does not
deliver an extra fixed `Cookie` header, so the full run's automatic rule
selected C-alt (`raw/a2/orchestrator_logs/a2_full.log`, first line).

**Expected:** no Not-Recognized fault. Replay R6b shows that with the header
`checkout` answers 200 for the same session that gets 401 without it (R6a).

**Prediction** (`notes/a2_predictions.md`): `refresh/checkout` no longer
reported; the other 4 still reported.

**Observed:** `refresh/checkout` reported 0/3 (logged-in users never got 401
on it: 200 × 6); the other 4 reported 3/3 each. Prediction held.
Raw output: `raw/a2/C-alt/`.

## Assignment 3

**Role:** matched control of P (the trigger of the `refresh/checkout` false
alarm, a missing `Authorization` header, is removed; everything else fixed).
**Run:** `PLAN="baseline:C-alt proto:C-alt" scripts/a3_run_all.sh`.
**Expected:** no Not-Recognized fault. **Observed:** baseline 4 endpoints as
305, not `checkout` (3/3); proto none confirmed, the same 4 as 950 (3/3), v1 and
v2. Raw: `raw/a3/*/C-alt/`, `raw/a3_v2/proto/C-alt/`.
