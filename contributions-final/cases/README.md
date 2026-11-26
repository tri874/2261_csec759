# Case index

## Final project

Question: does the prototype remove false Not-Recognized reports and keep true
ones on real APIs and on cases not used to develop it, why, and at what cost
(`../report.md`)? Predictions and labels of the synthetic cases, committed
before any final run: `../notes/final_predictions.md`. Labels of the real
targets, written after reading their source: `../notes/final_labels.md`. Run:
`../scripts/final_run_all.sh` (groups `synthetic`, `scaling`, `crapi`,
`webgoat`); table: `python3 ../scripts/final_table.py` → `../derived/final_summary.md`.

| ID | Role | Folder | Origin | Expected Not-Recognized | Configurations run (runs) |
|---|---|---|---|---|---|
| crapi | Held-out real API | [`crapi/`](crapi/) | OWASP crAPI v1.1.6, unmodified; 38 of 44 operations fuzzed (credential-changing ones excluded, `../notes/final_decisions.md` D4) | none found (the only report, the login endpoint, is labelled no fault) | baseline (5), proto (5), rule1, rule2, forkoff (3 each); 30 min |
| wgfull | Real API, full schema | `../environment/config/` (`webgoat-spec.json`, `webgoat-em.yaml`) | WebGoat, pinned image, 204 operations | none (5 JWT endpoints labelled no fault in A2) | baseline (3 fresh + A1's 10), proto (5), forkoff (3); 1 h |
| H5 | Held-out: second scheme | [`H5_second_scheme/`](H5_second_scheme/) | ours (`final_synthetic_app`, `CASE=H5`) | none | baseline, proto, rule1, rule2 (3 each); 2 min |
| H6 | Held-out: redirect login, true fault | [`H6_redirect_login/`](H6_redirect_login/) | ours, `CASE=H6` | `GET /api/billing` | as H5 |
| H7 | Held-out: evidence via a creating POST | [`H7_creating_post/`](H7_creating_post/) | ours, `CASE=H7` | `GET /api/export` | as H5 |
| H8 | Held-out: three users, two denied | [`H8_three_users/`](H8_three_users/) | ours, `CASE=H8` | `DELETE /api/admin/cache` | as H5 |
| S<E>x<U> | Scaling grid | [`final_scaling/`](final_scaling/), app [`final_scaling_app/`](final_scaling_app/) | generated: E ∈ {5,10,20,40} protected endpoints, U ∈ {2,4,8} users; plan in `final_scaling_app/plan.py` | the "true" endpoints in each cell's `labels.json` (20% of E) | forkoff, proto (3 each); 5 min |
| regression | A3 cases on the final image | (A3 folders below) | A3 | as in A3 | proto (3 each), `../raw/final_regress/` |
| final replays | Ground truth of H5–H8 | `../scripts/final_replays.sh` | ours | see `../notes/final_predictions.md` | deterministic, 21 requests |

H5–H8 share one app (`final_synthetic_app/`, port 8083), written after the
prototype was frozen and not used to tune it; the scaling app listens on
8084. Users are identified by a fixed `Authorization` header (as in K and
H1–H4); H8 configures three users.

## Assignment 3 pilot

Question: does the prototype (EvoMaster 6.2.0 + Rule 1 credential-differential
evidence + Rule 2 user attribution, `../patches/`) remove the A2 false alarms
and keep true Not-Recognized faults? Predictions, committed before the runs:
`../notes/a3_predictions.md`. Run everything: `../scripts/a3_run_all.sh`;
table: `python3 ../scripts/a3_table.py` → `../derived/a3_summary.md`.

| ID | A3 role | Folder | Target | Expected Not-Recognized | Changed vs A2 | Configurations run |
|---|---|---|---|---|---|---|
| P | Primary A2 failed case | [`P_webgoat_jwt/`](P_webgoat_jwt/) | WebGoat (pinned), JWT lesson | none | unchanged (fresh runs) | baseline, proto, rule1, rule2, forkoff |
| C-alt | Matched control of P | [`C-alt_auth_header/`](C-alt_auth_header/) | as P, users also send `Authorization: Bearer a2-control` | none | unchanged | baseline, proto |
| H1 | Additional variant | [`H1_apikey/`](H1_apikey/) | our app, `CASE=H1`: 401 login + `X-Api-Key` second credential | none | new in A3 (A2 plan's held-out case 1) | baseline, proto, rule1, rule2 |
| H1c | Matched control of H1 | [`H1c_apikey_userbug/`](H1c_apikey_userbug/) | as H1, but the 401 depends on the user only | `POST /api/vault` | new in A3 | baseline, proto |
| K | Regression check | [`k_notrecognized/`](k_notrecognized/) | K app (port of EvoMaster's `NotRecognizedApplication`) | `POST /api/resources/` | budget 2 min (A2: 5 min) | baseline, proto, forkoff |
| H2 | Tradeoff (predicted recall loss) | [`H2_role/`](H2_role/) | our app, `CASE=H2`: admin-only endpoint, 401 to every user | `DELETE /api/admin/cache` | new in A3 (A2 plan's held-out case 2) | baseline, proto |
| H4 | Mechanism case for Rule 1 | [`H4_misconfigured_user/`](H4_misconfigured_user/) | our app, `CASE=H4`: misconfigured user ZED | none | new in A3 | baseline, proto, rule1, rule2 |
| A3 replays | Ground truth of H1, H1c, H2, H4 | `../scripts/a3_replays.sh` | our app | see each case README | new | deterministic, once |
| A2 replays R1–R7 | Target state of WebGoat and K | `../scripts/a2_replays.sh` | WebGoat, K | `../notes/a2_predictions.md` | rerun in A3 | deterministic, once |
| E2E | Focused test inside EvoMaster | `SecurityNotRecognizedConfirmationEMTest` (in the patch) | EvoMaster's own `NotRecognizedApplication` (white-box) | 305 still found with both rules on | new | `STEPS=tests scripts/a3_build_fork.sh` |

Configurations: **baseline** = official EvoMaster 6.2.0 image (as A1/A2);
**proto** = our image, both rules on; **rule1** / **rule2** = one rule only
(ablation); **forkoff** = our image, both rules off (checks our build). All
black-box, 2 configured users, seeds 1–3 (3 runs per item). Budget: 5 min on
WebGoat (as A2), 2 min on the synthetic apps (3–4 endpoints). WebGoat is
restarted before each item, the synthetic apps before each run.

Expected results are set by construction and checked with curl (replays),
independently of EvoMaster; the basis for each is in the case's README.

H1, H1c, H2 and H4 share one app (`a3_synthetic_app/`, selected with the `CASE`
environment variable), written by us for A3. Its resource endpoints copy case K.

## Assignment 2 cases

Failure family: the Not-Recognized oracle (EvoMaster 6.2.0, black-box)
attributes 401s caused by request-level credentials or inputs to the
configured user. Predictions (committed before each run):
`../notes/a2_predictions.md`; answers and summary: the A2 submission (`report.pdf`, not in this package;
in git history at commit `357fde5`).

| ID | Role | Folder | Target | One factor changed vs P | Expected Not-Recognized | Raw output |
|---|---|---|---|---|---|---|
| K | Known working example | [`k_notrecognized/`](k_notrecognized/) | Case K app (port of EvoMaster's `NotRecognizedApplication`) | (different target) | `POST /api/resources/` for FOO (true fault) | `raw/a2/K/` |
| P | Primary failed case | [`P_webgoat_jwt/`](P_webgoat_jwt/) | WebGoat (pinned), JWT lesson | — | none | `raw/a2/P/` |
| C-alt | Matched control | [`C-alt_auth_header/`](C-alt_auth_header/) | as P | auth config: users also send `Authorization: Bearer a2-control` | none | `raw/a2/C-alt/` |
| C | Planned control, not used | [`C_cookie_not_used/`](C_cookie_not_used/) | as P | auth config: users also send the lesson `access_token` cookie | none | `raw/a2_pilot/C/` (pilot only) |
| V | Additional variant | [`V_exclude_votings_login/`](V_exclude_votings_login/) | as P | `--endpointExclude /JWT/votings/login` | none | `raw/a2/V/` |
| V2 | Follow-up variant | [`V2_exclude_both/`](V2_exclude_both/) | as P | `--endpointExclude /JWT/votings/login,/JWT/refresh/checkout` | none | `raw/a2/V2/` |
| R1–R7 | Deterministic replays | `../scripts/a2_replays.sh` | WebGoat and K | — | see `../notes/a2_predictions.md` | `raw/a2/replays/` |

Common to all A2 EvoMaster cases: EvoMaster 6.2.0
(`webfuzzing/evomaster@sha256:de1f4387e809a309a4c61517f3340c3d0b733b78bbb86d0e3ebd217d343515ab`),
black-box, 2 configured users, seeds 1–3, 5 minutes per run, target restarted
before each case (WebGoat) or each run (K).

Constructed or adapted by us: K (ported), C-alt, C, V and V2 (controlled
configurations), and the replays.
