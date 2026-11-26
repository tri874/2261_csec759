# Case V: additional variant (exclude the lesson login)

**One factor changed vs P:** `--endpointExclude /JWT/votings/login`
([`evomaster-args.diff`](evomaster-args.diff)). EvoMaster no longer calls
`GET /JWT/votings/login`, the endpoint that supplied the "requires a login"
evidence in the A1 baseline (401 for an unknown lesson user, 200 for `user=`).
`--endpointExclude` matches the schema path, which has no `/WebGoat` prefix
(EvoMaster v6.2.0 `EndpointFilter.kt`). Command: `STEPS="V" scripts/a2_run_all.sh`.

**Expected:** no Not-Recognized fault.

**Prediction, recorded before the run** (`notes/a2_predictions.md`, commit
`6236406`): `votings/{title}`, `refresh/login` and `refresh/newToken` are no
longer reported; `refresh/checkout` still is (it serves as its own evidence).
Alternative outcome also recorded: some remain, with `refresh/checkout`
supplying the evidence.

**Observed:** `checkout`, `refresh/login`, `refresh/newToken` and
`votings/{title}` reported 3/3 each. The main prediction failed; the recorded
alternative held. In all 10 Not-Recognized tests of V the evidence was
`refresh/checkout` (401 without the `Authorization` header, 200 with a junk
one): `derived/a2_evidence.csv`. Raw output: `raw/a2/V/`.
