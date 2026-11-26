#!/bin/bash
# final_replays.sh
#
# Deterministic curl checks of the expected behavior (ground truth) of the
# final-project held-out cases H5-H8, independent of EvoMaster
# (notes/final_predictions.md). Same format as a3_replays.sh: each request's
# command, headers, body and status are saved under OUT_DIR, with a summary in
# OUT_DIR/replays.csv.
#
# Optional environment variables:
#   S_URL     default http://localhost:8083
#   OUT_DIR   default raw/final/replays
#   APP_MODE  docker (default): build cases/final_synthetic_app as image final-synth
#             local: run the app with the local python3 (needs Flask), no Docker

set -uo pipefail

REPO_ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
S="${S_URL:-http://localhost:8083}"
OUT_DIR="${OUT_DIR:-${REPO_ROOT}/raw/final/replays}"
APP_MODE="${APP_MODE:-docker}"
APP_DIR="${REPO_ROOT}/cases/final_synthetic_app"
mkdir -p "${OUT_DIR}"
OUT_DIR="$(cd "${OUT_DIR}" && pwd)"
CSV="${OUT_DIR}/replays.csv"

echo "id,case,request,expected,observed,match" > "${CSV}"

if [ "${APP_MODE}" = "docker" ]; then
  docker build -q -t final-synth "${APP_DIR}" > /dev/null
fi
{
  echo "date_utc: $(date -u +%Y-%m-%dT%H:%M:%SZ)"
  echo "s_url: ${S}"
  echo "app_mode: ${APP_MODE}"
  echo "app_sha256: $(sha256sum "${APP_DIR}/app.py" 2>/dev/null || shasum -a 256 "${APP_DIR}/app.py")"
  [ "${APP_MODE}" = "docker" ] && echo "final_synth_image: $(docker image inspect --format '{{.Id}}' final-synth)"
} > "${OUT_DIR}/environment.txt"

CURRENT_CASE=""
LOCAL_PID=""

stop_app() {
  if [ "${APP_MODE}" = "docker" ]; then
    docker rm -f final-synth > /dev/null 2>&1
  elif [ -n "${LOCAL_PID}" ]; then
    kill "${LOCAL_PID}" 2> /dev/null; wait "${LOCAL_PID}" 2> /dev/null; LOCAL_PID=""
  fi
}
trap stop_app EXIT

start_case() { # CASE: fresh app, empty state
  CURRENT_CASE="$1"
  stop_app
  if [ "${APP_MODE}" = "docker" ]; then
    docker run -d --name final-synth -e "CASE=$1" -p 127.0.0.1:8083:8083 final-synth > /dev/null
  else
    (cd "${APP_DIR}" && CASE="$1" exec python3 app.py > /dev/null 2>&1) &
    LOCAL_PID=$!
  fi
  for _ in $(seq 60); do
    [ "$(curl -s -o /dev/null -w '%{http_code}' "${S}/login")" != "000" ] && return 0
    sleep 1
  done
  echo "ERROR: case $1 app did not start"; exit 1
}

TOTAL=0; MATCHED=0
# replay ID EXPECTED "description" curl-args...
replay() {
  local id="$1" expected="$2" desc="$3" code match="no"
  shift 3
  printf 'curl' > "${OUT_DIR}/${id}.cmd"; printf ' %q' "$@" >> "${OUT_DIR}/${id}.cmd"; echo >> "${OUT_DIR}/${id}.cmd"
  code="$(curl -s -o "${OUT_DIR}/${id}.body" -D "${OUT_DIR}/${id}.headers" -w '%{http_code}' "$@")"
  [ "${code}" = "${expected}" ] && match="yes" && MATCHED=$((MATCHED + 1))
  TOTAL=$((TOTAL + 1))
  echo "${id},${CURRENT_CASE},\"${desc}\",${expected},${code},${match}" >> "${CSV}"
  printf '%-5s %-3s %-64s expected %s, got %s  %s\n' "${id}" "${CURRENT_CASE}" "${desc}" "${expected}" "${code}" \
    "$([ "${match}" = yes ] && echo OK || echo DIFFERS)"
}

# H5: the 401 on reports asks for the second credential (same for every user).
start_case H5
replay H5-1 201 "PUT /api/resources/7 as FOO (FOO is recognized)"    -X PUT -H "Authorization: FOO" "${S}/api/resources/7"
replay H5-2 401 "PUT /api/resources/8 without credentials"             -X PUT "${S}/api/resources/8"
replay H5-3 401 "POST /api/reports as FOO, wrong key"                   -X POST -H "Authorization: FOO" -H "X-Api-Key: nope" "${S}/api/reports"
replay H5-4 401 "POST /api/reports as BAR, same wrong key"              -X POST -H "Authorization: BAR" -H "X-Api-Key: nope" "${S}/api/reports"
replay H5-5 204 "POST /api/reports as FOO, key r3p0rt"                  -X POST -H "Authorization: FOO" -H "X-Api-Key: r3p0rt" "${S}/api/reports"

# H6: anonymous requests are redirected; FOO's 401 on billing depends on the user.
start_case H6
replay H6-1 201 "PUT /api/resources/7 as FOO (FOO is recognized)"    -X PUT -H "Authorization: FOO" "${S}/api/resources/7"
replay H6-2 302 "PUT /api/resources/8 without credentials (redirect)"  -X PUT "${S}/api/resources/8"
replay H6-3 302 "GET /api/billing without credentials (redirect)"      "${S}/api/billing"
replay H6-4 401 "GET /api/billing as FOO"                               -H "Authorization: FOO" "${S}/api/billing"
replay H6-5 200 "GET /api/billing as BAR"                               -H "Authorization: BAR" "${S}/api/billing"

# H7: evidence through a creating POST; FOO's 401 on export depends on the user.
start_case H7
replay H7-1 201 "POST /api/items as FOO, category books"                -X POST -H "Authorization: FOO" -H "Content-Type: application/json" -d '{"category":"books"}' "${S}/api/items"
replay H7-2 401 "POST /api/items without credentials"                   -X POST -H "Content-Type: application/json" -d '{"category":"books"}' "${S}/api/items"
replay H7-3 403 "POST /api/items as BAR, category restricted"           -X POST -H "Authorization: BAR" -H "Content-Type: application/json" -d '{"category":"restricted"}' "${S}/api/items"
replay H7-4 403 "GET /api/items/1 as BAR (FOO's item)"                  -H "Authorization: BAR" "${S}/api/items/1"
replay H7-5 401 "GET /api/export as FOO"                                -H "Authorization: FOO" "${S}/api/export"
replay H7-6 200 "GET /api/export as BAR"                                -H "Authorization: BAR" "${S}/api/export"

# H8: FOO and BAR are recognized but get 401 on the admin endpoint; ADM gets 204.
start_case H8
replay H8-1 201 "PUT /api/resources/7 as FOO (FOO is recognized)"    -X PUT -H "Authorization: FOO" "${S}/api/resources/7"
replay H8-2 401 "DELETE /api/admin/cache as FOO"                        -X DELETE -H "Authorization: FOO" "${S}/api/admin/cache"
replay H8-3 401 "DELETE /api/admin/cache as BAR"                        -X DELETE -H "Authorization: BAR" "${S}/api/admin/cache"
replay H8-4 204 "DELETE /api/admin/cache as ADM"                        -X DELETE -H "Authorization: ADM" "${S}/api/admin/cache"
replay H8-5 401 "DELETE /api/admin/cache without credentials"           -X DELETE "${S}/api/admin/cache"

stop_app
echo
echo "Summary: ${MATCHED} of ${TOTAL} replays matched the expected status."
[ "${MATCHED}" = "${TOTAL}" ]
