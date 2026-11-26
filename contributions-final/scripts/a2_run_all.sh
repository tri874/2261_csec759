#!/bin/bash
# a2_run_all.sh
#
# Runs the Assignment 2 experiments in plan order (cases/README.md):
# case K, then the WebGoat cases P, C and V (WebGoat restarted
# before each), then the deterministic replays and the results table.
#
# Environment variables:
#   MODE     full  (default): 3 runs x 5 min per case, into raw/a2/
#            pilot: 1 run x 2 min per case, into raw/a2_pilot/ (setup
#                   checks only, not reported)
#   STEPS    which steps to run, in order (default: "K P C V replays table";
#            V2 is a follow-up variant, run separately: STEPS="V2 table")
#   CONTROL  auto (default): in a full run, apply the plan's decision rule to
#                  the pilot: cookie if some POST /JWT/votings/{title} call
#                  returned 202 in raw/a2_pilot/C/run_*, otherwise auth.
#                  A pilot run always uses cookie (that is what it checks).
#            cookie: control C sends Tom's access_token cookie
#            auth: control C-alt sends Authorization: Bearer a2-control
#   RUNS, MAX_TIME, ROOT   override the MODE defaults
#
# Example:
#   MODE=pilot scripts/a2_run_all.sh 2>&1 | tee logs/a2_pilot.log

set -euo pipefail

REPO_ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
cd "${REPO_ROOT}"

MODE="${MODE:-full}"
if [ "${MODE}" = "pilot" ]; then
  RUNS="${RUNS:-1}"; MAX_TIME="${MAX_TIME:-2m}"; ROOT="${ROOT:-raw/a2_pilot}"
else
  RUNS="${RUNS:-3}"; MAX_TIME="${MAX_TIME:-5m}"; ROOT="${ROOT:-raw/a2}"
fi
STEPS="${STEPS:-K P C V replays table}"
CONTROL="${CONTROL:-auto}"
if [ "${CONTROL}" = "auto" ] && [[ " ${STEPS} " == *" C "* ]]; then
  if [ "${MODE}" = "pilot" ]; then
    CONTROL=cookie
  elif ! ls -d raw/a2_pilot/C/run_* > /dev/null 2>&1; then
    echo "ERROR: CONTROL=auto needs the pilot's control run (raw/a2_pilot/C/run_*). Run MODE=pilot first, or set CONTROL=cookie or CONTROL=auth."
    exit 1
  elif python3 scripts/a2_table.py --vote-accepted raw/a2_pilot/C/run_*; then
    CONTROL=cookie
    echo "Control decision: the pilot's C run got 202 on POST /JWT/votings/{title}, so the cookie reaches WebGoat -> using C (cookie)."
  else
    CONTROL=auth
    echo "Control decision: no 202 on POST /JWT/votings/{title} in the pilot's C run, so the cookie does not reach WebGoat -> using C-alt (Authorization header)."
  fi
fi
WEBGOAT="http://localhost:8080"
K_URL="http://localhost:8081"
export RUNS MAX_TIME

log() { echo; echo "##### $(date -u +%H:%M:%S) $*"; }

wait_for() { # URL SECONDS: wait until anything answers with HTTP status other than 000
  local url="$1" secs="$2"
  for _ in $(seq "${secs}"); do
    [ "$(curl -s -o /dev/null -w '%{http_code}' "${url}" || true)" != "000" ] && return 0
    sleep 1
  done
  echo "ERROR: ${url} did not come up within ${secs}s"
  exit 1
}

restart_webgoat() {
  log "restarting WebGoat (accounts kept in the webgoat_data volume)"
  docker restart webgoat > /dev/null
  wait_for "${WEBGOAT}/WebGoat/login" 300
  # The login page answers before the app is fully ready; give it a moment.
  sleep 10
}

start_k() {
  log "building and starting case K app"
  docker build -q -t a2-k cases/k_notrecognized
  docker rm -f a2-k > /dev/null 2>&1 || true
  docker run -d --name a2-k -p 127.0.0.1:8081:8081 a2-k > /dev/null
  wait_for "${K_URL}/api/resources/1" 60
}

run_k() {
  start_k
  log "case K: ${RUNS} run(s) x ${MAX_TIME}"
  CASE_DIR=cases/k_notrecognized SPEC_FILE=openapi.json CONFIG_FILE=k-em.yaml \
    TARGET="${K_URL}" RESULTS_ROOT="${ROOT}/K" STAT_ID=k \
    RESET_CMD="docker restart a2-k >/dev/null && for i in \$(seq 60); do [ \"\$(curl -s -o /dev/null -w '%{http_code}' ${K_URL}/api/resources/1)\" != 000 ] && exit 0; sleep 1; done; exit 1" \
    scripts/run_evomaster_case.sh
}

run_webgoat_case() { # NAME CONFIG_FILE EXTRA_ARGS
  local name="$1" config="$2" extra="$3"
  restart_webgoat
  log "case ${name}: ${RUNS} run(s) x ${MAX_TIME}, config ${config}, args: ${extra}"
  CONFIG_FILE="${config}" EXTRA_ARGS="${extra}" RESULTS_ROOT="${ROOT}/${name}" \
    scripts/run_evomaster_webgoat.sh
  cp "environment/config/${config}" "${ROOT}/${name}/auth-config.yaml"
  log "case ${name}: status codes of the JWT calls kept in the generated tests"
  python3 scripts/a2_table.py --calls "${ROOT}/${name}"/run_*
}

make_cookie_config() {
  log "fetching a lesson access_token for user Tom"
  local jar token
  jar="$(mktemp)"
  curl -s -c "${jar}" -o /dev/null -d "username=useraa&password=userAA" "${WEBGOAT}/WebGoat/login"
  curl -s -b "${jar}" -c "${jar}" -o /dev/null "${WEBGOAT}/WebGoat/JWT/votings/login?user=Tom"
  token="$(awk '$6 == "access_token" {print $7}' "${jar}" | tail -1)"
  rm -f "${jar}"
  if [ -z "${token}" ]; then
    echo "ERROR: could not get an access_token from ${WEBGOAT}/WebGoat/JWT/votings/login?user=Tom"
    exit 1
  fi
  mkdir -p environment/config/generated
  sed "s|__ACCESS_TOKEN__|${token}|" environment/config/webgoat-em-c-cookie.template.yaml \
    > environment/config/generated/webgoat-em-c-cookie.yaml
}

for step in ${STEPS}; do
  case "${step}" in
    K) run_k ;;
    P) run_webgoat_case P webgoat-em.yaml "--endpointPrefix /JWT" ;;
    C)
      if [ "${CONTROL}" = "cookie" ]; then
        # The token is signed with a fixed lesson key, so it stays valid
        # across the WebGoat restart that run_webgoat_case does next.
        make_cookie_config
        run_webgoat_case C generated/webgoat-em-c-cookie.yaml "--endpointPrefix /JWT"
      else
        run_webgoat_case C-alt webgoat-em-c-auth.yaml "--endpointPrefix /JWT"
      fi
      ;;
    V) run_webgoat_case V webgoat-em.yaml "--endpointPrefix /JWT --endpointExclude /JWT/votings/login" ;;
    V2) run_webgoat_case V2 webgoat-em.yaml "--endpointPrefix /JWT --endpointExclude /JWT/votings/login,/JWT/refresh/checkout" ;;
    replays)
      log "deterministic replays"
      docker ps --format '{{.Names}}' | grep -qx a2-k || start_k
      OUT_DIR="${ROOT}/replays" scripts/a2_replays.sh
      ;;
    table)
      log "results table"
      python3 scripts/a2_table.py "${ROOT}"
      ;;
    *) echo "ERROR: unknown step ${step}"; exit 1 ;;
  esac
done

log "done: ${STEPS} (mode ${MODE}, results in ${ROOT})"
