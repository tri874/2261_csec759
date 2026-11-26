# Case K: known working example

**Role.** Confirms that the Not-Recognized oracle works in our setup on a
true fault, so the WebGoat results are not a broken-tool artifact.

**Provenance (borrowed and adapted).** Python/Flask port of EvoMaster's own
end-to-end test application for this oracle:
`core-tests/e2e-tests/spring/spring-rest-openapi-v3/src/main/kotlin/com/foo/rest/examples/spring/openapi/v3/security/notrecognized/NotRecognizedApplication.kt`,
EvoMaster v6.2.0, https://github.com/WebFuzzing/EvoMaster/tree/v6.2.0 (LGPL-3.0).
It implements the scenario of the paper's Figure 1 (Arcuri et al., ISSRE 2025, §III-A).

**Inputs.**

| File | Content |
|---|---|
| `app.py` | The API: `PUT`/`GET /api/resources/{id}` (owner-checked) and `POST /api/resources/` (BAR only) |
| `openapi.json` | Schema given to EvoMaster |
| `k-em.yaml` | Two users, FOO and BAR, each sent as a fixed `Authorization` header |
| `Dockerfile` | `python:3.12-slim` + `flask==3.1.1`, port 8081 |

Differences from the original (none affect the oracle's logic): a missing
`Authorization` header returns 401 (Spring would return 400 before the
handler runs); a non-integer `{id}` returns 400. The `{id}` parameter is
declared per operation because EvoMaster 6.2.0 cannot read path-level
parameters (found in the pilot, see `../../notes/a2_investigation_log.md`).

**Expected behavior and basis.** `POST /api/resources/` answers 401 to FOO,
who is recognized (FOO can create and read resources), and 204 to BAR. A
recognized user should get 403, so this is a true Not-Recognized fault, by
construction and by the original test's intent. Replays R7a–c check it
(FOO → 401, BAR → 204, no header → 401).

**Run.** `STEPS="K" scripts/a2_run_all.sh` (builds and starts the container,
restarts it before each run). Raw output: `raw/a2/K/`.

**Observed.** Reported in 3/3 runs; no other Not-Recognized report.

## Assignment 3

**Role:** regression check (previously correct behavior). Budget 2 min (A2:
5 min); app restarted before each run. **Run:**
`PLAN="baseline:K proto:K forkoff:K" scripts/a3_run_all.sh`. **Expected:**
`POST /api/resources/` confirmed (305). **Observed:** confirmed in 3/3 runs
under baseline, proto (v1 and v2) and forkoff; with the rules on, the test also
shows the replays (Y without credentials → 401, X as BAR → 204). Raw:
`raw/a3/*/K/`, `raw/a3_v2/proto/K/`.
