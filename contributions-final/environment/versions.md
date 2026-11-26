# Versions, artifacts and hardware

How to set up and start everything: [`setup.md`](setup.md). Each set of runs
also records its own versions in `raw/<set>/<case>/environment.txt`.

## Tool and target

| Component | Version / identifier | Source |
|---|---|---|
| EvoMaster (baseline tool) | 6.2.0, Docker image `webfuzzing/evomaster@sha256:de1f4387e809a309a4c61517f3340c3d0b733b78bbb86d0e3ebd217d343515ab` (pinned default in both run scripts) | https://github.com/WebFuzzing/EvoMaster, tag `v6.2.0` |
| WebGoat (target) | Docker image `webgoat/webgoat@sha256:157df88eacf392acf110e24fa973aa72cb3484c16abdd7f17b142b5973d8b54c`, created 2026-09-11T13:44:09Z. The image does not record its source commit. | https://github.com/WebGoat/WebGoat. The JWT lesson files we rely on (`src/main/java/org/owasp/webgoat/lessons/jwt/JWTVotesEndpoint.java`, `JWTRefreshEndpoint.java`) were last changed in commit `7533e971ef` (2026-06-20), before the image was built |
| WebGoat schema | `config/webgoat-spec.json`, OpenAPI 3.0.1, 204 operations, SHA-256 `cf2ac2263983b92708d44f42c7096c5a284e2d8237007c577824793c7a4d33f7` | WebFuzzing/Dataset (https://github.com/WebFuzzing/Dataset), `openapi-swagger/`; copied in A1 (Dataset commit not recorded) |
| Case K app | `python:3.12-slim` + `flask==3.1.1` (`../cases/k_notrecognized/Dockerfile`) | Port of EvoMaster v6.2.0 `NotRecognizedApplication.kt` (see `../cases/k_notrecognized/README.md`) |
| Paper | A. Arcuri, O. Sahin, M. Zhang, "Fuzzing for Detecting Access Policy Violations in REST APIs," ISSRE 2025, pp. 130–141, doi:10.1109/ISSRE66568.2025.00025 | The extension is part of EvoMaster ("released as open-source at www.evomaster.org", p. 140) |

## Auth configs (SHA-256)

| File | Used by | SHA-256 |
|---|---|---|
| `config/webgoat-em.yaml` | A1 baseline, P, V, V2 | `bbe70a3521f66dfdb835cc78084edde80175098c7372b8df96f878c70d3112db` |
| `config/webgoat-em-c-auth.yaml` | C-alt | `6412eef588d6bed22b6f1de80288700eff64669ba7796524b03d5fe8ae3cb30f` |
| `config/webgoat-em-c-cookie.template.yaml` | C (pilot only) | `0931723232346633d5d293fbdb26659a07c2d536ed2f5814ac33bc70ffe4173f` |
| `../cases/k_notrecognized/k-em.yaml` | K | — |

The WebGoat accounts (`useraa`/`userAA`, `userbb`/`userBB`) are throwaway
test accounts on a local WebGoat instance, registered for this project only.

## Host

| Item | Value |
|---|---|
| OS / kernel | Ubuntu (VM), Linux 7.0.0-31-generic x86_64 (from `raw/*/environment.txt`) |
| Docker | 29.1.3 (Linux host networking: EvoMaster uses `--network host`) |
| Python | Python 3 on the VM (used by the scripts; standard library only) |
| CPU | 4 vCPUs, Intel Xeon E5-2697 v4 @ 2.30GHz (`nproc`, `lscpu`) |
| Memory | 7.3 GiB RAM, no swap (`free -h`) |

## Changes from Assignment 1

| Change | Why |
|---|---|
| Valid baseline uses EvoMaster 6.2.0 (A1's first runs used 6.1.1 via `latest`) | The fixed A1 baseline was run with 6.2.0; A2 reuses it and pins it |
| `--bbTargetUrl http://localhost:8080` and login endpoint `/WebGoat/login` | A1's first runs doubled the base path (`/WebGoat/WebGoat/...`); kept as `raw/pre_fix/` |
| WebGoat pinned by digest | `latest` changes over time |
| A2 runs: 5-minute budget, 3 seeds, `--endpointPrefix /JWT` | Focus on the JWT lesson; the A1 2-minute and 1-hour runs report the same 5 endpoints |
| WebGoat restarted before each A2 case; case K restarted before each run | Reset target state between configurations |
| `raw/` (was `results/`), per-run `run_meta.txt` (start/end time, exit status) from now on | Required ZIP layout; A2 runs before this change have times and exit status inferred from EvoMaster's own records (`derived/a2_run_index.csv`) |

## Assignment 3 additions

| Component | Version / identifier | Source / record |
|---|---|---|
| Prototype source | EvoMaster tag `v6.2.0`, commit `efad6f2bd7ff0025852a6203d307303c568e763a` + `patches/evomaster-v6.2.0-a3.patch` (sha256 `b9a4cdd8…98ee74`) | `scripts/a3_build_fork.sh` clones, checks the commit, applies the patch |
| Prototype v1 image (pilot, `raw/a3/`) | `evomaster-a3:b9a4cdd80388`, image id `sha256:bc61d3f4…6e38869b3589`, jar sha256 `83b0455d…17e6bb0` | `a3_build.txt` |
| Diagnostics image (`raw/a3_diag/`) | v1 + `patches/evomaster-a3-diagnostics.patch` (logging only) | `a3_build_diag.txt` |
| Prototype v2 image (`raw/a3_v2/`) | v1 + diagnostics + `patches/evomaster-a3-fix-replay-stopping.patch` | `a3_build_v2.txt` |
| Build toolchain | `maven:3.9.9-eclipse-temurin-17` (Maven in Docker; JDK 17 as EvoMaster's `java.version`), runtime base `amazoncorretto:21-alpine-jdk` (EvoMaster's own Dockerfile) | `a3_build*.txt` |
| WFC (fault codes) | `com.webfuzzing:commons` 0.8.0 (EvoMaster 6.2.0 dependency); codes 9xx are free for experimental categories, so the new category uses 950 | https://github.com/WebFuzzing/Commons tag v0.8.0 |
| Synthetic app (H1, H1c, H2, H4) | `python:3.12-slim` + `flask==3.1.1` (`../cases/a3_synthetic_app/Dockerfile`), port 8082 | written by us |
| Host | same VM as A1/A2 (table above) | `raw/a3/*/*/environment.txt` |

A3 budgets: 5 min per run on WebGoat (as A2), 2 min per run on the synthetic
apps and K (A2 ran K for 5 min); seeds 1–3. The baseline image is the official
6.2.0 image above; the prototype is built from the same tag.

## Final project additions

| Component | Version / identifier | Source / record |
|---|---|---|
| Final image (`raw/final/`, `raw/final_regress/`) | `evomaster-final:5b1bbe97bf05`, image id `sha256:7574768f…3c6642`, jar sha256 `38f277fe…3215df`: v2 + `patches/evomaster-final-cost-log.patch` (logging only) | `final_build.txt` |
| crAPI | OWASP crAPI tag `v1.1.6`, commit `700f03d12a392d9e408260b4beae72ed02a4a1a4`; images pinned by digest in `../cases/crapi/compose.pinned.yml` (the tag's commit, `main` images of 2025-09-22; postgres:14 and mongo:4.4 digests of 2026-11-12) | `crapi_images.txt`, `../scripts/final_crapi.sh` |
| crAPI schema and auth | `../cases/crapi/crapi-openapi-spec.json` (from the tag, sha256 `9dc66ecf…66bceb`), `em.yaml` (sha256 `6056fca3…ca011e4`), seeded users adam007 and pogba006 | `../cases/crapi/README.md` |
| Held-out synthetic app (H5–H8) | `python:3.12-slim` + `flask==3.1.1` (`../cases/final_synthetic_app/Dockerfile`), port 8083 | written by us |
| Scaling app | same base, port 8084; behavior from `../cases/final_scaling_app/plan.py` | written by us |
| Host | same VM as A1–A3 | `raw/final/*/*/environment.txt` |

Final budgets: WebGoat full API 1 h, crAPI 30 min, H5–H8 2 min, scaling 5 min;
seeds 1..n (5 runs for baseline/proto on the real APIs, 3 otherwise).
