# Environment setup

Run everything on a Linux host with Docker and Python 3. EvoMaster uses
`--network host` to reach WebGoat on `localhost`, which needs Linux Docker.
Run all commands from the repository root.

## 1. Start WebGoat

The baseline in `raw/webgoat/` used this exact image (built
2026-09-11; the JWT lesson code it contains has been unchanged on WebGoat's
`main` branch since 2026-06-20). Pull it by digest so later runs use the same
WebGoat:

```bash
WEBGOAT_IMAGE=webgoat/webgoat@sha256:157df88eacf392acf110e24fa973aa72cb3484c16abdd7f17b142b5973d8b54c
docker pull "$WEBGOAT_IMAGE"

docker run --name webgoat -d \
  -p 127.0.0.1:8080:8080 \
  -p 127.0.0.1:9090:9090 \
  -e LOGGING_LEVEL_ORG_SPRINGFRAMEWORK_SECURITY=DEBUG \
  -v webgoat_data:/home/webgoat \
  "$WEBGOAT_IMAGE"
```

Only start one WebGoat. The WebFuzzing/Dataset repo also has a
`dockerfiles/webgoat.yaml` compose file, but starting it as well would clash on
port 8080. The Dataset repo is only the source of
`environment/config/webgoat-spec.json`, which is already committed.

## 2. Create the two accounts

Visit http://localhost:8080/WebGoat/registration and register the two accounts
listed in `environment/config/webgoat-em.yaml` (`useraa` / `userAA` and
`userbb` / `userBB`).

Check that each login works. A successful login redirects to the WebGoat start
page instead of back to `/login?error`:

```bash
curl -s -o /dev/null -w '%{http_code} %{redirect_url}\n' \
  -d "username=useraa&password=userAA" \
  http://localhost:8080/WebGoat/login
```

## 3. Run EvoMaster

Ten runs of 1 hour each take about 10 hours, so run it inside tmux:

```bash
mkdir -p logs
tmux new-session -d -s webgoat "scripts/run_evomaster_webgoat.sh 2>&1 | tee logs/webgoat.log"
```

For a quick check that the setup works before committing 10 hours, run one
short run first:

```bash
MAX_TIME=2m RUNS=1 RESULTS_ROOT=raw/smoke scripts/run_evomaster_webgoat.sh
```

The script stops with an error if a run gets no successful (2xx) responses,
which means the target URL or the accounts are wrong.

## 4. Compute the Table III metrics

```bash
python3 scripts/extract_metrics.py raw/webgoat --csv derived/summary.csv
```

## 5. Assignment 3: build the prototype and run the pilot

Needs only Docker and git on the host (Maven and the JDK run in a container).
WebGoat and the two accounts as in steps 1–2.

```bash
mkdir -p logs
# v1 prototype (about 15 min the first time; downloads Maven dependencies)
scripts/a3_build_fork.sh 2>&1 | tee logs/a3_build.log
# setup check, about 10 min
MODE=smoke scripts/a3_run_all.sh 2>&1 | tee logs/a3_smoke.log
# pilot, about 4 h
scripts/a3_run_all.sh 2>&1 | tee logs/a3_full.log
```

v2 (with the D3 fix) and the rerun of the prototype items: see the README,
"Reproducing the pilot".

## 6. Final project: final image, crAPI and the campaign

Final image (v2 + cost log) and crAPI, then the campaign groups (README,
"Reproducing the final results"):

```bash
BUILD_DIR=../evomaster-final IMAGE=evomaster-final:5b1bbe97bf05 \
  EXTRA_PATCHES="patches/evomaster-a3-diagnostics.patch patches/evomaster-a3-fix-replay-stopping.patch patches/evomaster-final-cost-log.patch" \
  BUILD_RECORD=environment/final_build.txt scripts/a3_build_fork.sh 2>&1 | tee logs/final_build.log
scripts/final_crapi.sh setup      # clone crAPI v1.1.6, check the commit, pull the pinned images
scripts/final_crapi.sh up && scripts/final_crapi.sh check   # both logins must succeed
scripts/final_crapi.sh down
GROUP=smoke scripts/final_run_all.sh 2>&1 | tee logs/final_smoke.log
```

Notes: crAPI's containers have fixed names (`mailhog`, `postgresdb`, ...); remove
any older crAPI install first. Its first start takes about 2 minutes (identity
service). WebGoat (port 8080), crAPI (8888, 8025, 8443, 30080, 30443) and the
synthetic apps (8083, 8084) can run at the same time.
