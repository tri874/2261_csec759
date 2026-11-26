# Confirming Not-Recognized Faults in EvoMaster

CSEC 759, Fall 2026, final project. An extension of EvoMaster 6.2.0's
Not-Recognized oracle, evaluated against the unmodified tool on two real APIs
(WebGoat, crAPI), held-out synthetic cases and a generated API of growing size.

| Student | ID |
|---|---|
| James Southcott | jms9508@rit.edu |
| Tri Tran | ttt6380@rit.edu |

**Baseline.** A. Arcuri, O. Sahin, M. Zhang, "Fuzzing for Detecting Access
Policy Violations in REST APIs," ISSRE 2025, doi:10.1109/ISSRE66568.2025.00025
(extended version: arXiv:2604.00702); the Not-Recognized oracle as implemented
in **EvoMaster 6.2.0** (official image
`webfuzzing/evomaster@sha256:de1f4387…343515ab`).

**Our change.** EvoMaster v6.2.0 + `patches/`: before a 401 for a configured
user is reported as Not-Recognized (code 305), **Rule 1** requires that the
user's 2xx request on another endpoint gets 401/403 when replayed without
credentials, and **Rule 2** requires that the same request as another
configured user does not get 401. Candidates that fail are reported as code
**950** (low confidence) instead. Options `--notRecognizedCredentialEvidence`,
`--notRecognizedUserAttribution` (both off by default).

**Results** (`report.md`, `derived/final_summary.md`):

- Real APIs: the baseline's false alarms are all removed, and kept as 950.
  WebGoat full API, 1 h: 5 per run → 0 (3 fresh baseline runs, 5 prototype
  runs). crAPI v1.1.6, 30 min: 1 per run → 0 (5 + 5 runs). Neither API exposed
  a true Not-Recognized fault.
- Held-out synthetic H5–H8 (written after the prototype was frozen,
  predictions committed before any run): every prediction held; precision
  0.75 → 1.00, recall 1.00 → 0.67 (the predicted loss on a redirect-login API).
- Mechanism: one rule at a time removes exactly the false alarms its mechanism
  predicts, on synthetic cases and on crAPI; our build with the rules off
  matches the official image on WebGoat and crAPI.
- Cost: +0.7 s and +65 HTTP calls per 1-hour WebGoat run (< 0.03%). On a
  generated API the cost grows linearly with endpoints and quadratically with
  users; at 40 endpoints × 8 users it exhausts the security phase's time box
  and one true fault per run is lost.

## Where things are

| Path | Content |
|---|---|
| `report.md` (→ `report.pdf`) | Final report: problem, related work, method with a worked example, setup, results (RQ1–RQ4), limitations |
| `patches/` | Source changes against EvoMaster tag `v6.2.0` (commit `efad6f2`), apply order, hashes, every modified file (`patches/README.md`). Final image = v1 patch + diagnostics + D3 fix + cost log |
| `cases/` | Case index `cases/README.md`. Real: `crapi/` (schema, auth config, pinned compose override). Held-out synthetic: `H5_*`–`H8_*` with `final_synthetic_app/`. Scaling: `final_scaling_app/` (app and `plan.py`) and generated `final_scaling/E<e>_U<u>/`. A2/A3 cases: P, C-alt, K, H1, H1c, H2, H4 |
| `tests/` | `tests/README.md`: checks T1–T13 (EvoMaster e2e/unit tests, ablations, build checks, curl ground truth, regression, cost line) |
| `scripts/` | Build, run, check, table and figure scripts (below) |
| `raw/final/` | Final runs: `<config>/<case>/run_<i>/` (EvoMaster output, `run_meta.txt`), `environment.txt` per item, `items.csv` (every attempted item and its exit status), `replays/` |
| `raw/final_regress/` | A3 cases rerun on the final image |
| `raw/final_smoke/`, `raw/final_smoke2/` | crAPI before the credential fix (evidence for D4), and the setup check of the final scripts; not scored |
| `raw/webgoat/` | A1's 10 baseline runs on the full WebGoat API (reported as `baseline_A1`) |
| `raw/a3*/`, `raw/a2*/` | A3 pilot, diagnostics and v2; A2 runs (unchanged) |
| `derived/` | `final_summary.md`, `final_runs.csv` (per run), `final_results.csv` (per case × config), `final_scaling.csv`, `fig_scaling_*.svg`; A3/A2 tables |
| `environment/` | `final_build.txt` (final image record), `crapi_images.txt` (crAPI image ids and digests), `versions.md`, `setup.md`, A3 build records, WebGoat configs |
| `notes/` | `final_predictions.md` (before any final run), `final_labels.md`/`.csv`, `final_decisions.md` (D4–D7), `a3_decisions.md` (D1–D3), `contributions.md`, `ai-use.md`; A2/A3 plans and predictions |
| `presentation/` | All Slide Decks |

## Requirements

Linux host with Docker (EvoMaster uses `--network host`), git, curl, Python 3
(standard library only). No JDK or Maven on the host: EvoMaster is built with
Maven in `maven:3.9.9-eclipse-temurin-17`. Our runs: one VM with 4 vCPUs
(Xeon E5-2697 v4), 7.3 GiB RAM, Docker 29.1.3, Linux 7.0.0-31
(`environment/versions.md`). Disk: about 5 GB for the EvoMaster images and
Maven cache, plus a few GB for the crAPI images. Memory: crAPI used about
0.5 GB idle with our limits (`scripts/final_crapi.sh check`), EvoMaster 1–2 GB, WebGoat about 1 GB.

## Short test (seconds, no Docker)

Re-derive every final table and figure from the packaged raw output:

```bash
python3 scripts/final_table.py raw/final && python3 scripts/final_figures.py
```

Expected: `derived/final_summary.md`, whose cases table includes

| Case | Role | Config | Budget | Runs ok | Confirmed (305) | Unconfirmed (950) | TP/FP/FN |
|---|---|---|---|---|---|---|---|
| crapi | held-out real API (crAPI v1.1.6) | baseline | 30m | 5/5 | POST:/identity/api/auth/login (5/5) | none | 0/5/0 |
| crapi | held-out real API (crAPI v1.1.6) | proto | 30m | 5/5 | none | POST:/identity/api/auth/login (5/5) | 0/0/0 |

(shortened). The ground truth of H5–H8 can also be checked without Docker if
Flask is installed: `APP_MODE=local OUT_DIR=/tmp/replays scripts/final_replays.sh`
→ `Summary: 21 of 21 replays matched the expected status.`

## Short test with the tools (about 1 h)

WebGoat set up as in `environment/setup.md` (steps 1–2), then:

```bash
mkdir -p logs
# final image (~10 min with a warm Maven cache, ~15 min the first time)
BUILD_DIR=../evomaster-final IMAGE=evomaster-final:5b1bbe97bf05 \
  EXTRA_PATCHES="patches/evomaster-a3-diagnostics.patch patches/evomaster-a3-fix-replay-stopping.patch patches/evomaster-final-cost-log.patch" \
  BUILD_RECORD=environment/final_build.txt scripts/a3_build_fork.sh 2>&1 | tee logs/final_build.log
# crAPI images (once, ~5 min)
scripts/final_crapi.sh setup
# smoke: H6, H7, one scaling cell, crAPI baseline and proto, 1 short run each (~35 min)
GROUP=smoke scripts/final_run_all.sh 2>&1 | tee logs/final_smoke.log
```

Expected (as in `raw/final_smoke2/`): H6 proto downgrades `GET /api/billing`
(950), H7 proto confirms `GET /api/export` (305), scaling `S5x2` forkoff TP
1/FP 1 and proto TP 1/FP 0, crAPI baseline reports the login endpoint and proto
downgrades it, and `Summary: 21 of 21 replays matched the expected status.`

## Reproducing the final results

The scripts skip items that already have runs: move `raw/final` aside or set
`ROOT`. Every run is listed in `items.csv` with its exit status; failed runs
are kept, not rerun silently. Wall-time on our VM in brackets.

```bash
GROUP=synthetic scripts/final_run_all.sh   # H5-H8 x 4 configs x 3 runs, 2 min      (~2 h)
GROUP=scaling   scripts/final_run_all.sh   # 12 cells x forkoff, proto x 3, 5 min   (~6.5 h)
GROUP=crapi     scripts/final_run_all.sh   # 19 runs of 30 min, crAPI reset each     (~11 h)
GROUP=webgoat   scripts/final_run_all.sh   # proto 5 x 1 h                           (~5 h)
GROUP=webgoat PLAN="baseline:wgfull:3 forkoff:wgfull:3" scripts/final_run_all.sh   # (~6 h)
# A3 cases on the final image (~1.5 h)
PROTO_IMAGE=evomaster-final:5b1bbe97bf05 ROOT=raw/final_regress \
  PLAN="proto:K proto:H1 proto:H1c proto:H2 proto:H4 proto:P proto:C-alt" \
  STEPS="runs table" scripts/a3_run_all.sh
# EvoMaster's tests touched by the patches, on the final build (~20 min)
BUILD_DIR=../evomaster-final STEPS=tests TESTS_OUT=raw/final/build scripts/a3_build_fork.sh
# tables and figures (seconds)
python3 scripts/final_table.py raw/final && python3 scripts/final_figures.py
```

Each group ends with its table; the synthetic group also runs the H5–H8
replays. Use tmux: the full campaign took about 33 VM-hours.

## Scripts

| Script | What it does |
|---|---|
| `scripts/a3_build_fork.sh` | Clones EvoMaster `v6.2.0`, checks the commit, applies the patches (`EXTRA_PATCHES`), builds `evomaster.jar` with Maven in Docker, builds the image, writes the build record; `STEPS=tests` runs EvoMaster's affected unit and e2e tests (`TESTS_OUT`) |
| `scripts/final_run_all.sh` | Final campaign: `variant:case[:runs]` items in groups (`synthetic`, `scaling`, `crapi`, `webgoat`, `smoke`), target setup and reset before every run, replays, table |
| `scripts/final_crapi.sh` | crAPI v1.1.6: `setup` (clone, commit check, pinned images), `up`, `reset` (fresh databases), `check` (logins and a few calls), `down` |
| `scripts/final_replays.sh` | Curl ground truth of H5–H8 (21 requests); Docker or `APP_MODE=local` |
| `scripts/final_gen_scaling.py` | Writes the schema, auth config and labels of each scaling cell from `plan.py` |
| `scripts/final_table.py` | Per-run and aggregated results, labels, TP/FP/FN, cost of the Not-Recognized step, scaling table, call sequences |
| `scripts/final_figures.py` | Scaling figures (SVG) from `derived/final_scaling.csv` |
| `scripts/run_evomaster_case.sh`, `scripts/run_evomaster_webgoat.sh` | One target: `RUNS` × `MAX_TIME`, seeds 1..RUNS, image and extra options, reset command, per-run `run_meta.txt`, `KEEP_GOING` |
| `scripts/a3_*`, `scripts/a2_*`, `scripts/extract_metrics.py` | A3, A2 and A1 scripts (A3 pilot reproduction: section "Assignment 3" of `cases/README.md` and the A3 commands below) |

A3 pilot (66 runs, ~4 h) and its v2 rerun: `scripts/a3_run_all.sh`, then
`python3 scripts/a3_table.py raw/a3` (details in `patches/README.md` and
`tests/README.md`).

## Known limitations

- Two real APIs, one of which (WebGoat) motivated the rules; no true
  Not-Recognized fault was found in either, so recall on real software is not
  measured. Held-out synthetic cases were written by us (after the prototype
  was frozen).
- crAPI: six credential-changing endpoints excluded, container limits raised,
  chatbot not started (`notes/final_decisions.md` D4).
- 3–5 runs per configuration; EvoMaster 6.2.0, black-box only.
- The rules cannot confirm faults on APIs that redirect anonymous requests to
  a login page, or on endpoints that every configured user is denied; at large
  endpoints × users the step can exceed the security time box.
- WebGoat and crAPI accounts are local test accounts (crAPI's seeded users);
  no other credentials are included.

## Background (A1–A3)

A1 reproduced the WebGoat row of the paper's Table III (Not-Recognized 5.0).
A2 showed that those 5 reports are false alarms caused by the JWT lesson's own
credentials and inputs. A3 implemented the two rules and piloted them on
seven cases (`raw/a3*`, `notes/a3_*`).
