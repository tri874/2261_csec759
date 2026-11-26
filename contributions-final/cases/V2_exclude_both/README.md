# Case V2: follow-up variant (exclude both evidence endpoints)

**Added after V's full run, prediction committed before V2 ran**
(`notes/a2_predictions.md`, commit `d16bb5e`).

**One factor changed vs P:**
`--endpointExclude /JWT/votings/login,/JWT/refresh/checkout`
([`evomaster-args.diff`](evomaster-args.diff)): both endpoints whose 401
depends on the request's inputs and that also give the same user a 2xx.
Command: `STEPS="V2 table" scripts/a2_run_all.sh`.

**Expected:** no Not-Recognized fault.

**Prediction:** no Not-Recognized reports. The other 401s remain, but no
remaining JWT endpoint gives the same user both a 401/403 and a 2xx, and
WebGoat answers 302 (not 401) without a session, so the oracle has no
"requires a login" evidence.

**Observed:** no Not-Recognized report in 3/3 runs, while logged-in users
still got 401 on `votings/{title}`, `refresh/login` and `refresh/newToken`
(6 times each, `derived/a2_call_statuses.csv`). Prediction held.
Raw output: `raw/a2/V2/`.
