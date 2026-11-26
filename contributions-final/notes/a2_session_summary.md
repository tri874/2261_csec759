# Session summary: Assignment 1 fixes and Assignment 2

What was done in the working session of 2026-09-30 to 2026-10-02 (James
Southcott with Claude), from finishing Assignment 1 to packaging
Assignment 2. This file replaces the working documents `ASSIGNMENT2_PLAN.md`
and `ASSIGNMENT2_RESULTS.md` (still in the git history: plan first committed
in `3b4ef9b`, results in `d8ed214`). `notes/a2_predictions.md` refers to
"`ASSIGNMENT2_PLAN.md`, section 5"; those case definitions are now in
`cases/README.md` and section 4 below. The dated timeline is in
`notes/a2_investigation_log.md`.

## 1. Assignment 1: from a broken run to a valid baseline

**Starting point.** The A1 repo reproduced the WebGoat row of Table III of
Arcuri, Sahin and Zhang, "Fuzzing for Detecting Access Policy Violations in
REST APIs" (ISSRE 2025, p. 138): H500 32.0, Schema 2192.2, Not-Recognized
5.0, Leakage 0.0, Missed-Check 0.0. The first runs reported H500 0,
Schema 204, everything else 0, explained as unpinned versions.

**What was actually wrong.** Every request went to `/WebGoat/WebGoat/...`:
the schema's server URL already adds `/WebGoat` and the run script also
passed `--bbTargetUrl http://localhost:8080/WebGoat`. No endpoint returned a
2xx (`covered2xx = 0`); each of the 204 operations got one Schema fault for an
undocumented 302/404 reply. The runs also used a 2-minute budget instead of
the paper's 1 hour. These runs are kept as `raw/pre_fix/`.

**Fixes (commits `10070d5` … `729337f`).**

- `scripts/run_evomaster_webgoat.sh`: target is the host root; refuses a
  target that repeats the base path; stops when a run gets no 2xx; 1-hour
  default; pinned EvoMaster image; records versions in `environment.txt`;
  absolute results path (Docker treats relative `-v` paths as volume names);
  only a finished run blocks a re-run.
- `environment/config/webgoat-em.yaml`: login endpoint `/WebGoat/login`.
- `scripts/extract_metrics.py`: EvoMaster 6.2.0 changed the summary separator
  (`;` → `|`) and renumbered fault codes (Schema 101 → 200, Not-Recognized
  801 → 305), so codes are matched to Table III metrics by the fault
  description in the generated tests; warnings for runs without 2xx
  responses and mixed budgets; CSV output; run ordering and column fixes.

**Valid baseline** (`raw/webgoat/`, EvoMaster 6.2.0, 10 × 1 h, seeds 1–10,
2026-10-01 05:50–16:09 UTC; smoke check `raw/smoke/`):

| Metric | Paper | Baseline (mean, sd) |
|---|---|---|
| H500 | 32.0 | 28.0 (0.00) |
| Schema | 2192.2 | 323.4 (0.52) |
| Not-Recognized | 5.0 | 5.0 (0.00) |
| Leakage | 0.0 | 0.0 (0.00) |
| Missed-Check | 0.0 | 0.0 (0.00) |

172–173 of 204 endpoints reached a 2xx in every run. Not-Recognized flagged
the same 5 JWT-lesson endpoints in every run. The Schema gap is not explained
by search time (2-minute smoke run: 320). WebGoat was then pinned by digest
(`webgoat/webgoat@sha256:157df88e…`, built 2026-09-11).

Also produced during A1 (not in the repo): presentation-generator prompts
for the defense deck (7-slide and 2-slide versions), two rounds of review of
the generated decks, and speaker notes.

## 2. Assignment 2: finding the failure family

Observations on the valid baseline (`raw/webgoat/`):

1. No response was a 403 in about 9,800 parsed responses, so Leakage and
   Missed-Check were never applicable on WebGoat (side finding).
2. Requests without a session always got 302 (3,414 times), never 401.
3. All 195 401s went to logged-in users, only on `/WebGoat/JWT/` endpoints.
4. The 5 Not-Recognized reports' call sequences used, as evidence, a 401 and
   a 200 for the same user on one endpoint with different inputs.

WebGoat's source (JWT lesson, `main`; unchanged since commit `7533e971ef`,
2026-06-20) explains every 401:

| Reported endpoint | Why WebGoat returns 401 | Source (`src/main/java/org/owasp/webgoat/lessons/jwt/`) |
|---|---|---|
| `GET /JWT/votings/login` | lesson login: `user` not a substring of `"TomJerrySylvester"` | `JWTVotesEndpoint.java` 109–130 |
| `POST /JWT/votings/{title}` | lesson `access_token` cookie missing or invalid | `JWTVotesEndpoint.java` 167–190 |
| `POST /JWT/refresh/login` | body is not lesson user Jerry with the lesson password | `JWTRefreshEndpoint.java` 49–65 |
| `POST /JWT/refresh/newToken` | `Authorization` header or refresh token missing or invalid | `JWTRefreshEndpoint.java` 108–137 |
| `POST /JWT/refresh/checkout` | `Authorization` header missing (any value gives 200) | `JWTRefreshEndpoint.java` 83–106 |

EvoMaster v6.2.0 implements the oracle in
`core/src/main/kotlin/org/evomaster/core/problem/rest/oracle/RestSecurityOracle.kt`,
`hasNotRecognizedAuthenticated` (556–605): a 401 for a configured user on X
is reported if the same user got a 2xx on some endpoint Y in the test, and Y
returned 401 or 403 to anyone, with any inputs ("it can be the same user");
Y = X is not excluded although the paper requires Y ≠ X (§III-A, p. 132).

**Failure family.** The Not-Recognized oracle attributes 401s caused by
request-level credentials or inputs to the configured user's login, and
accepts such 401s as evidence that a user's login works. All 5 of WebGoat's
reports, the paper's 5.0, are false alarms of this kind.

Directions considered and not chosen: Leakage/Missed-Check never applicable
(fix would only change reporting); plain BOLA in the IDOR lesson (outside the
paper's stated scope); the Schema gap (not a security property).

## 3. Expected behavior (ground truth)

For all 5 endpoints the correct verdict is "no Not-Recognized fault":

- the paper defines Not-Recognized as a *recognized* user getting 401
  instead of 403; here the WebGoat session is recognized (no session → 302)
  and the 401 refers to another credential or a failed lesson login;
- RFC 9110 §15.5.2: 401 means the request lacks valid credentials for the
  target resource, the correct status for a missing lesson credential;
- the source lines above, and the replays (section 5).

These responses do omit `WWW-Authenticate`, which EvoMaster reports
separately (codes 109, 202); the claim concerns code 305 only.

## 4. Experiment design

All EvoMaster runs: 6.2.0 (pinned), black-box, 2 users, seeds 1–3, 5 minutes,
WebGoat restarted before each case, case K restarted before each run.
Predictions committed before the runs (`6236406`; V2: `d16bb5e`).

| ID | Role | Setup (one factor vs P) | Expected | Prediction |
|---|---|---|---|---|
| K | Known working example | Python port of EvoMaster's `NotRecognizedApplication.kt` (paper Fig. 1): `POST /api/resources/` 401 for FOO, 204 for BAR | 1 true fault | reported |
| P | Primary failed case | WebGoat, `--endpointPrefix /JWT` | none | all 5 reported |
| C | Planned control | + users send Tom's lesson `access_token` cookie | none | vote report disappears |
| C-alt | Fallback control | + users send `Authorization: Bearer a2-control` | none | checkout report disappears |
| V | Additional variant | + `--endpointExclude /JWT/votings/login` | none | 3 reports disappear; alternative: `checkout` supplies the evidence |
| V2 | Follow-up variant | + exclude `/JWT/votings/login,/JWT/refresh/checkout` | none | no reports |

Pre-registered control rule: if no vote call returns 202 in the pilot's C
run, use C-alt. Deterministic replays R1–R7 (`scripts/a2_replays.sh`): no
session 302; userA 401; userB 401; userA + Tom's token 202; lesson login
`?user=Tom` 200 / `?user=zzz` 401; checkout without/with header 401/200;
K as FOO/BAR/none 401/204/401.

## 5. Implementation

| Path | Content |
|---|---|
| `cases/` | Case index and one folder per case (inputs, diffs, expected behavior, provenance); K's app, schema, auth config, Dockerfile |
| `environment/config/webgoat-em-c-*.yaml` | Control configs (cookie template, Authorization header) |
| `scripts/a2_run_all.sh` | Runs K, P, C/C-alt (`CONTROL=auto` applies the rule), V, V2, replays, table; `MODE=pilot` |
| `scripts/run_evomaster_case.sh` | Runner for non-WebGoat targets, with a reset command |
| `scripts/run_evomaster_webgoat.sh` | Gained `CONFIG_FILE`, `EXTRA_ARGS`, per-run `run_meta.txt` |
| `scripts/a2_replays.sh` | Replays R1–R7 |
| `scripts/a2_table.py` | Results table, run index, evidence analysis, status counts (`derived/a2_*`) |

EvoMaster details that shaped the code (v6.2.0 source): `--endpointPrefix` and
`--endpointExclude` match schema paths without `/WebGoat` and exclude every
method on a path (`EndpointFilter.kt`); fixed auth headers override schema
headers of the same name (`HttpWsFitness.kt`); login cookies and fixed
headers are added by different calls (`AuthUtils.kt`).

## 6. Execution (UTC, 2026-10-01/02)

1. **Pilot** 21:10–21:24 (1 × 2 min per case, `raw/a2_pilot/`): K and P as
   predicted; K's schema used a path-level `{id}` EvoMaster cannot read
   (fixed, `06c664c`); C's vote endpoint still reported and no vote call
   returned 202, so the extra `Cookie` header does not reach WebGoat →
   C-alt.
2. **Full run** 22:16–23:24 (`raw/a2/`, log `raw/a2/orchestrator_logs/a2_full.log`):
   first line records the C-alt decision.
3. **V2** 23:55–00:11, prediction committed first.
4. Results pushed (`fd961c3`); pilot and logs added later (`5d442f1`).

All 15 reported runs completed with their own seed, about 5 minutes each, no
doubled paths, same images throughout.

## 7. Results

| Case | Not-Recognized reported (runs) | Interpretation | Prediction |
|---|---|---|---|
| K | `POST /api/resources/` (3/3) | correct | held |
| P | all 5 JWT endpoints (3/3 each) | 5 false alarms | held |
| C-alt | 4 endpoints (3/3); `refresh/checkout` 0/3 | checkout's false alarm removed | held |
| V | `checkout`, `refresh/login`, `refresh/newToken`, `votings/{title}` (3/3) | evidence moved to `checkout` | main failed; recorded alternative held |
| V2 | none (0/3) | correct | held |

Replays: 12/12 matched. Evidence analysis (`derived/a2_evidence.csv`): in all
32 Not-Recognized tests of P, C-alt and V, the evidence calls differ in a
request input (`Authorization` header 22, query parameter 10); 24 involve one
user only. C-alt: `checkout` never answered 401 to a logged-in user (200 × 6).
V2: logged-in users still got 401 on the other three endpoints (6 each) with
no report. K's evidence is legitimate (e.g. FOO 403 then 204 on
`PUT /api/resources/{id}`).

**Where the weaknesses live.**

| Failure | Layer |
|---|---|
| "Y requires a login" accepted from a 401 caused by request inputs, even from the same user | Published method (§III-A, T3 "any call on Y") and code comment |
| A 401 caused by a second credential attributed to the configured user | Published method (only configured users vs no auth are modelled) |
| An endpoint serving as its own evidence (Y = X) | EvoMaster 6.2.0 implementation |

**Limitations.** One real target and one constructed case; EvoMaster 6.2.0
only; 5-minute focused runs (the 1-hour full-API baseline reports the same 5);
the cookie control could not be used; call sequences come from the tests
EvoMaster keeps; A2 run times and exit status are inferred from EvoMaster's
records (`derived/a2_run_index.csv`); whether the paper's 5 are the same
endpoints is unconfirmed (the 401 logic is unchanged since at least Feb 2025).

## 8. Proposed change (detail in `notes/a3_plan.md`)

Before confirming Not-Recognized for user A on X: (1) credential-differential
evidence: the identical request on Y ≠ X without credentials gets 401/403
(a 302 redirect does **not** count, because V2 shows counting it would
validate every WebGoat session); (2) user attribution: the identical request
on X as another configured user gets something other than 401. Otherwise,
report in a lower-confidence category instead of dropping it.

## 9. Packaging for submission

- Repository laid out as the brief requires: `README.md`, `environment/`
  (`setup.md`, `versions.md` with versions, checksums, host: 4 vCPU Xeon
  E5-2697 v4, 7.3 GiB), `cases/`, `scripts/`, `raw/` (renamed from
  `results/`), `derived/`, `notes/`, `report.pdf`.
- `notes/`: predictions, dated investigation log with decisions D1–D6,
  `contributions.md`, A2 section of `ai-use.md`, this summary, `a3_plan.md`.
  The A1 report is `notes/a1_report.pdf`.
- Q1–Q8 answers: Claude drafted `report.md`; we rewrote them in our own words
  as `report.pdf`, which Claude then reviewed against the brief.
- Removed as not needed for submission: `ASSIGNMENT2_PLAN.md`,
  `ASSIGNMENT2_RESULTS.md` (folded into this file), the `report.md` draft
  (superseded by `report.pdf`) and the A1 prediction note.
