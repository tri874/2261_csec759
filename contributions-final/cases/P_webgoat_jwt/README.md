# Case P: primary failed case (WebGoat JWT lesson)

**Inputs.**

| Input | Value |
|---|---|
| Target | WebGoat `webgoat/webgoat@sha256:157df88eacf392acf110e24fa973aa72cb3484c16abdd7f17b142b5973d8b54c` (built 2026-09-11), `http://localhost:8080` |
| Schema | `environment/config/webgoat-spec.json` (from WebFuzzing/Dataset; server URL `http://localhost:8080/WebGoat`) |
| Auth config | `environment/config/webgoat-em.yaml` (users `useraa`, `userbb`; form login at `/WebGoat/login`, session cookie) |
| EvoMaster options | `--blackBox true --problemType REST --bbTargetUrl http://localhost:8080 --maxTime 5m --seed {1,2,3} --endpointPrefix /JWT` (full command in `scripts/run_evomaster_webgoat.sh`) |
| Command | `STEPS="P" scripts/a2_run_all.sh` |

`--endpointPrefix /JWT` focuses the run on the JWT lesson (20–22 operations).
The A1 full-API baseline (`raw/webgoat/`) reported the same 5 endpoints.

**Reduced example (deterministic, `scripts/a2_replays.sh`).** For
`POST /WebGoat/JWT/votings/{title}`:

1. no session → 302 (R1): WebGoat's login layer redirects to the login page
2. logged in as `useraa` → 401 (R2); as `userbb` → 401 (R3)
3. logged in as `useraa`, plus the lesson's `access_token` cookie from
   `GET /WebGoat/JWT/votings/login?user=Tom` → 202 (R4)

**Expected behavior and basis: no Not-Recognized fault on any of the 5 endpoints.**

| Endpoint | Why WebGoat returns 401 | Source (WebGoat `src/main/java/org/owasp/webgoat/lessons/jwt/`) |
|---|---|---|
| `GET /JWT/votings/login` | lesson login: `user` is not a substring of `"TomJerrySylvester"` | `JWTVotesEndpoint.java` 109–130 |
| `POST /JWT/votings/{title}` | lesson `access_token` cookie missing or invalid | `JWTVotesEndpoint.java` 167–190 |
| `POST /JWT/refresh/login` | body is not lesson user `Jerry` with the lesson password | `JWTRefreshEndpoint.java` 49–65 |
| `POST /JWT/refresh/newToken` | `Authorization` header or refresh token missing/invalid | `JWTRefreshEndpoint.java` 108–137 |
| `POST /JWT/refresh/checkout` | `Authorization` header missing (any value gives 200) | `JWTRefreshEndpoint.java` 83–106 |

Line numbers are from WebGoat's `main` branch; neither file has changed since
commit `7533e971ef` (2026-06-20), before the image was built, and that commit
only touched `getVotes`. The user is recognized (with a session the 401s
appear, without one WebGoat answers 302), and the 401s refer to a different
credential or a failed lesson login, for which 401 is the correct status
(RFC 9110 §15.5.2). The paper defines Not-Recognized as a recognized user
getting 401 instead of 403 (§III-A).

**Observed.** All 5 endpoints reported in 3/3 runs (5 false alarms per run).
Raw output: `raw/a2/P/`.

## Assignment 3

**Role:** primary A2 failed case, unchanged inputs, fresh runs. **Run:**
`PLAN="baseline:P proto:P rule1:P rule2:P forkoff:P" scripts/a3_run_all.sh`
(5 min, seeds 1–3). **Expected:** no Not-Recognized fault. **Observed:**
baseline and forkoff report all 5 endpoints as 305 (3/3); proto, rule1 and
rule2 confirm none and report all 5 as 950 (3/3), in v1 and v2. Raw:
`raw/a3/<config>/P/`, `raw/a3_v2/<config>/P/`.
