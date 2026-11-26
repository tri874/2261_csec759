# Final project: technical decisions and change record

Continues `a3_decisions.md` (D1-D3). James Southcott and Tri Tran, with
Claude (`ai-use.md`). Dated; the code is EvoMaster v6.2.0 with our patches.

## D4 (2026-11-12) crAPI: what we run, and three deviations from a plain `docker compose up`

**Context.** crAPI is the second real target (paper RQ2, arXiv:2604.00702
Table 1). The first smoke runs (`raw/final_smoke/`, 5 min, 1 run each) showed
three problems.

1. **Images.** The tag `v1.1.6` has no `1.1.6` Docker image except for
   `crapi-identity`. The images built from the tag's commit (`700f03d`,
   2025-09-22) are the `main` tags of that day; we pin them by digest
   (`cases/crapi/compose.pinned.yml`).
2. **Container limits.** crAPI caps MongoDB at 128 MB; on our VM it stayed at
   the cap, paged (914 GB block reads) and never became healthy. We raised the
   limits of the databases and the three services (`compose.pinned.yml`). Only
   resources change, not code or data. The chatbot (OpenAI key, not in the
   schema) is not started; `crapi-web`'s chatbot route points at mailhog so
   its nginx starts.
3. **Credential-changing endpoints.** In both smoke runs every login failed
   from about 50 s into the 5-minute run (`Auth request failed with status
   401`): `POST /identity/api/v2/user/reset-password` sets a new password for
   the token's user with no old password (`UserServiceImpl.resetPassword`).
   After that, every request "as adam" carries no valid token, so the 401s the
   oracle sees are self-inflicted: the baseline reported 33 endpoints in one
   run, including the login endpoint itself (wrong password -> 401). The
   paper notes the same hazard for crAPI.

**Decision.** Exclude, for every configuration, the endpoints that change the
configured users' credentials: `reset-password`, `change-email`,
`verify-email-token`, `forget-password`, `v2/check-otp`, `v3/check-otp`
(`--endpointExclude`, `scripts/final_run_all.sh` `CRAPI_EXCLUDE`), and reset
crAPI's databases before every run. 38 of 44 operations remain.

**Consequence.** The comparison is fair (same exclusions, same resets for both
configurations), but it does not test those six endpoints. The smoke runs are
kept as evidence of the problem and are not scored.

## D5 (2026-11-12, revised 2026-11-15) WebGoat full API: fresh baseline runs, A1's kept for reference

First plan: compare the prototype (5 x 1 h, seeds 1-5) with A1's official-image
runs (`raw/webgoat/`, 10 x 1 h, seeds 1-10, same VM and WebGoat image) to save
5 VM-hours. The runs showed the two were not comparable in throughput: the
prototype sent 221k-253k HTTP calls per run, A1's baseline 148k-178k, although
the A3 5-minute runs (baseline and prototype on the same day) showed no such
gap. **Decision:** run 3 fresh baseline and 3 `forkoff` runs (same seeds,
script, budget, WebGoat restart before each group of runs) on 2026-11-14.
**Result:** fresh baseline 234k-246k calls and `forkoff` 233k-245k, matching
the prototype's runs 1-3 (240k-253k); the gap was the six weeks between
the runs, not the patch. All baseline runs (A1's 10 and the fresh 3) and the
3 `forkoff` runs report the same 5 JWT endpoints. The report compares with the
fresh runs; A1's are listed as `baseline_A1`.

## D6 (2026-11-12) Cost reference: `forkoff`, and a cost log line

The official image does not log the cost of the Not-Recognized step, so a
millisecond comparison with it is impossible. `evomaster-final-cost-log.patch`
(logging only) adds one line at the end of the step, with the rules on or off:
`Not-Recognized step cost (final): rulesEnabled= elapsedMs= evaluatedTests=
evaluatedCalls= timedOut=`. `forkoff` (our build, rules off) is the cost
reference; A3 showed it gives the same reports as the official image (P, K).

## D7 (2026-11-12) Scaling: a generated API, two dimensions

`cases/final_scaling_app` serves E protected endpoints and U users;
`plan.py` (shared by the app and the generator) plants a true fault on 20% of
the endpoints and a second credential on another 20%. E grows the number of
candidates; U grows the Rule 2 replays per candidate (U - 1) and the number of
users that can be a candidate. Labels come from the plan, not from EvoMaster.
Generated cases establish behavior only over the tested range (rubric).
