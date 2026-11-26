# Final project: predictions and labels (written before any final run)

Committed before the first run of `scripts/final_run_all.sh` (the commit
hash is the evidence of the order). The prototype is frozen: A3 v1 patch + D3
fix (`patches/`), plus a logging-only cost line (`evomaster-final-cost-log.patch`).
"Reported" = the endpoint has code 305 in a run; "downgraded" = 950 only.

## Held-out synthetic cases H5-H8 (labels by construction, checked by `scripts/final_replays.sh`, 21 requests)

| Case | Expected (label) | baseline | proto | rule1 only | rule2 only |
|---|---|---|---|---|---|
| H5 second scheme signalled by `WWW-Authenticate: ApiKey` | no fault | `POST:/api/reports` reported (FP) | downgraded | reported (FP): the login evidence is genuine | downgraded |
| H6 redirect login (302), FOO 401 on billing | true fault `GET:/api/billing` | reported (TP) | downgraded (FN): Rule 1 never finds evidence when anonymous requests get 302 | downgraded (FN) | reported (TP) |
| H7 evidence through a creating POST, FOO 401 on export | true fault `GET:/api/export` | reported (TP) | reported (TP) | reported (TP) | reported (TP) |
| H8 three users, FOO and BAR 401 on admin cache, ADM 204 | true fault `DELETE:/api/admin/cache` | reported (TP) | reported (TP): Rule 2 needs one other user without 401 (ADM) | reported (TP) | reported (TP) |

"Reported" means in at least 2 of 3 runs. Alternative outcomes we consider
possible: the search does not reach a 2xx for FOO in a 2-minute run (then no
candidate at all in that run, FN for every configuration); in H7 the Rule 1
evidence may come from `PUT /api/resources/{id}` instead of `POST /api/items`
(both are valid evidence; the A3-DIAG lines show which one was used).

## crAPI v1.1.6 (held-out real API; labels after the runs)

No labels before the runs: each reported endpoint (305 or 950) is labelled by
reading its source at the tag and by curl replays (`notes/final_labels.md`).
Predictions:

1. The baseline reports several endpoints. From the smoke run
   (`raw/final_smoke`, credential-changing endpoints not yet excluded) most of
   its 33 reported endpoints were caused by EvoMaster changing the users'
   passwords; with those endpoints excluded we expect fewer, mostly false alarms.
2. The prototype confirms fewer endpoints than the baseline; every endpoint it
   confirms is also reported by the baseline (the rules only remove reports).
3. crAPI's identity service answers some requests without a token with 404
   (`scripts/final_crapi.sh check` on 2026-11-12: dashboard without token, 404), so Rule 1 can
   only use endpoints whose anonymous replay gets 401/403. If none does, the
   prototype confirms nothing on crAPI (all downgraded).

## WebGoat full API, 1 h (baseline = A1's `raw/webgoat`, 10 runs)

- Baseline (A1): the 5 JWT endpoints, 5.0 per run (A1/A2).
- proto: **no 305 at all** in any run: WebGoat answers anonymous requests with
  302, so Rule 1 can never confirm (A3 Q8). The JWT endpoints appear as 950.

## Scaling grid (forkoff vs proto, E in {5,10,20,40} x U in {2,4,8}, 3 runs, 5 min)

Labels by construction (`cases/final_scaling/*/labels.json`): 20% "true" endpoints (fault), 20% "second" (no fault).

- forkoff reports the true endpoints it reaches (TP) and the "second"
  endpoints (FP), so precision about 0.5.
- proto reports the same true endpoints (TP) and downgrades every "second"
  endpoint: precision 1.0, recall equal to forkoff's within run-to-run noise.
- Cost: replay calls about candidates x (1 + (U - 1)) = candidates x U, where a
  "second" endpoint is a candidate for each of the U users and a "true" one for
  U0 only: so roughly E/5 x (1 + U) x U calls, growing linearly in E and
  quadratically in U. The Not-Recognized step time grows with it; at E=40,
  U=8 we expect the step to stay well under the security phase time box.
- Recall of both configurations may drop at E=40 within the fixed 5-minute
  budget (fewer endpoints reached), not because of the rules.

## Regression (final image on the A3 cases)

The final image differs from v2 only by a log line: the A3 v2 results hold
(P, C-alt, H1, H4 downgraded; K, H1c confirmed 3/3; H2 downgraded).
