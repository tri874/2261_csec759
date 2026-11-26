# Assignment 3: what needs to be done

A3 question (course brief): *can you build a working heuristic or tool for
the boundary found in A2?* The final project then asks whether it works, what
it costs, whether it scales, and where it still fails, so A3 should already
collect the data those questions need.

Background: `notes/a2_session_summary.md` (A2 findings), `report.pdf` Q7–Q8
(the proposal as submitted), `cases/README.md` (A2 cases).

## 1. Goal and research question

**RQ.** Does adding credential-differential evidence and user attribution to
EvoMaster's Not-Recognized oracle remove false alarms caused by request-level
credentials while keeping true Not-Recognized faults, and at what cost?

**Success looks like.** On the A2 cases: K still confirmed, all 5 WebGoat
false alarms downgraded, no change to other oracles' output; on held-out
cases: precision up without losing true faults except the predicted
recall-loss case; cost measured and explained.

## 2. The change

A fork of EvoMaster **v6.2.0** (https://github.com/WebFuzzing/EvoMaster, tag
`v6.2.0`; same version as the A2 baseline, so baseline and modified runs differ
only by the change).

Before confirming Not-Recognized for user A on call X (401):

```
confirm(A, X):
  # Rule 1: credential-differential evidence (paper's Y != X enforced)
  ok = any(Y != X and A got 2xx on request r on Y
           and replay(r, auth=NONE).status in {401, 403}    # a 302 redirect does NOT count
           for Y, r in test)
  # Rule 2: user attribution
  attributable = any(replay(X.request, auth=B).status != 401 for B in users - {A})
  return ok and attributable      # otherwise report in the new low-confidence category
```

Expected walkthroughs (from A2):

| Case | Rule 1 | Rule 2 | Result |
|---|---|---|---|
| WebGoat vote (P) | evidence `checkout`/`votings/login` replayed without session → 302 → rejected | vote as userB → 401 → not attributable | downgraded |
| K `POST /api/resources/` | `PUT /api/resources/30` (FOO 204) without auth → 401 → accepted | as BAR → 204 → attributable | confirmed |

**Integration points** (EvoMaster v6.2.0):

- `core/src/main/kotlin/org/evomaster/core/problem/rest/oracle/RestSecurityOracle.kt`:
  `hasNotRecognizedAuthenticated` (556–605) for the decision;
  `handleNotRecognizedAuthenticated` (141–180) where faults are added.
- `core/src/main/kotlin/org/evomaster/core/problem/rest/service/RestSecurityBuilder.kt`:
  add the replay calls (identical request, credentials removed or swapped) to
  the security test, so the generated test shows the evidence.
- Fault-category definitions (where `SECURITY_NOT_RECOGNIZED_AUTHENTICATED`
  is defined): add the new low-confidence category with its own code and
  description, so `report.json`, `statistics.csv` and test comments show it.
- `scripts/extract_metrics.py` and `scripts/a2_table.py` (copy to
  `a3_table.py`): recognize the new category by its description.

**Not in scope / differs from existing work:** `disabledOracleCodes`
(`EMConfig.kt` 3146–3150) only switches the oracle off; RESTler's
user-namespace rule assumes users must not access each other's resources.

## 3. Work items

1. **Build EvoMaster v6.2.0 from source unchanged** and confirm it reproduces
   the A2 results on K and P (same reports). This separates "our change" from
   "our build". Follow the repository's build instructions (Maven); record
   the JDK and Maven versions in `environment/versions.md`.
2. **Package the build as a Docker image** (e.g. `evomaster-a3:<git-sha>`) so
   the existing scripts can use it through `EVOMASTER_IMAGE`.
3. **Implement Rule 1 and Rule 2** and the new category. Keep each rule
   behind its own switch (a new option, or two images) so each can be
   evaluated alone.
4. **Unit/e2e checks**: run EvoMaster's existing security end-to-end tests
   (`core-tests/e2e-tests/spring/spring-rest-openapi-v3/.../security/`) on the
   fork; they must still pass.
5. **Build the held-out cases** (section 4) *before* finalizing the rules,
   with labels written down first.
6. **Scripts**: copy `scripts/a2_run_all.sh` to `a3_run_all.sh` with a
   `VARIANT=baseline|modified` switch; outputs under `raw/a3/baseline/` and
   `raw/a3/modified/` (keep baseline and modified runs distinguishable, as the
   brief requires); `run_meta.txt` is already written per run.
7. **Evaluation runs** (section 5) and the results table.
8. **Write-up and defense.**

## 4. Cases

**Tuning set (used while building):**

- K (`cases/k_notrecognized/`): must stay confirmed.
- WebGoat JWT lesson: P, C-alt, V, V2 configurations from A2.
- EvoMaster's own security e2e apps (NotRecognized, ExistenceLeakage,
  ForbiddenDelete, ForgottenAuthentication, …).

**Held out (not used to tune; label each before running):**

1. **401 login + API key**: an API whose main login answers 401 (not a
   redirect) and one endpoint that also needs an `X-Api-Key` header. Tests
   the X-side misattribution when the evidence is genuine (A2's remaining
   uncertainty): Rule 1 passes, so Rule 2 must catch it. Prediction for the
   current oracle: reported (false alarm).
2. **Role-restricted endpoint**: only a role that is not configured may call
   it, and it wrongly answers 401 to configured users. A true fault that
   Rule 2 will downgrade: the expected recall loss.
3. **crAPI or capital** (paper RQ2, from WebFuzzing/Dataset, run locally):
   real APIs with token login; the paper reports Not-Recognized 1.0 for
   crAPI. Label the reports by reading their source.
4. Optional: a variant of case 1 whose secondary credential answers 401
   with a `WWW-Authenticate` header naming another scheme.

Only local, legally distributable targets (WebGoat, Dataset APIs, our own
apps).

## 5. Evaluation protocol

- **Comparison**: baseline 6.2.0 image vs modified image; same targets,
  seeds (≥ 3), budget (5 min for focused runs; consider one 1-hour full-API
  WebGoat run to match A1), same restarts between runs.
- **Metrics**: precision and recall of Not-Recognized reports per case
  against the labels; number of downgraded candidates; per rule (Rule 1 only,
  Rule 2 only, both).
- **Regression**: EvoMaster's security e2e tests pass; K confirmed;
  H500, Schema and other oracle counts on WebGoat unchanged.
- **Cost**: security-phase duration ("Phase SECURITY lasted" in
  `evomaster_stdout.log`; 9 s in A2's P run 1), number of extra HTTP calls
  per candidate (log or count in the fork), total wall-clock time at equal
  search budget.
- **Scaling input** (for the final project): number of configured users
  (2, 5, 10) and number of endpoints with a second credential in a generated
  synthetic API; replay cost should grow with candidates × users.

## 6. Risks and fallback

| Risk | Fallback |
|---|---|
| EvoMaster's build or security-phase code takes too long to change | External post-processor: read `report.json` and the generated tests, replay each candidate's calls with credentials varied (Python `requests`), reclassify |
| Replaying state-changing requests (e.g. DELETE) changes the state the test relied on | Replay on a reset target, or only replay idempotent calls and report the rest as untested |
| Rule 2 loses true faults (held-out case 2) | Report as a measured recall cost; keep the finding in the low-confidence category instead of dropping it |
| Not enough time for both rules | Rule 2 only (it alone removes all 5 WebGoat false alarms) |

## 7. Responsibilities (from report Q8)

- James: initial integration in the EvoMaster fork.
- Tri: analyse the integration and run its initial tests.
- Both: analysis of results and the next steps; each must be able to explain
  the shared result at the defense.

## 8. Open items carried over from A2

- `notes/contributions.md` still needs the partner's specific A2 work.
- Uncertain: whether the paper's 5 WebGoat reports are the same 5 endpoints
  (not resolvable without the paper's raw output).
- Untested: other EvoMaster versions; APIs whose main login answers 401
  (held-out case 1 addresses this).
- Pilot runs and orchestrator logs are now in `raw/`; keep doing the same
  for A3 (copy `logs/*.log` into `raw/a3/orchestrator_logs/`).
