#!/bin/bash
# a3_replays.sh
#
# Deterministic curl checks of the expected behavior (ground truth) of the A3
# synthetic cases H1, H1c, H2 and H4, independent of EvoMaster
# (cases/README.md, notes/a3_predictions.md). For each case the app is started
# fresh with CASE=<id>; every request's command, headers, body and status are
# saved under OUT_DIR, and a summary under OUT_DIR/replays.csv.
#
# Needs Docker; builds cases/a3_synthetic_app as image a3-synth.
#
# Optional environment variables:
#   S_URL    default http://localhost:8082
#   OUT_DIR  default raw/a3/replays

set -uo pipefail

REPO_ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
S="${S_URL:-http://localhost:8082}"
OUT_DIR="${OUT_DIR:-${REPO_ROOT}/raw/a3/replays}"
mkdir -p "${OUT_DIR}"
OUT_DIR="$(cd "${OUT_DIR}" && pwd)"
CSV="${OUT_DIR}/replays.csv"

echo "id,case,request,expected,observed,match" > "${CSV}"

docker build -q -t a3-synth "${REPO_ROOT}/cases/a3_synthetic_app" > /dev/null
{
  echo "date_utc: $(date -u +%Y-%m-%dT%H:%M:%SZ)"
  echo "s_url: ${S}"
  echo "a3_synth_image: $(docker image inspect --format '{{.Id}}' a3-synth)"
} > "${OUT_DIR}/environment.txt"

CURRENT_CASE=""

start_case() { # CASE: fresh app, empty state
  CURRENT_CASE="$1"
  docker rm -f a3-synth > /dev/null 2>&1
  docker run -d --name a3-synth -e "CASE=$1" -p 127.0.0.1:8082:8082 a3-synth > /dev/null
  for _ in $(seq 60); do
    [ "$(curl -s -o /dev/null -w '%{http_code}' "${S}/api/resources/1")" != "000" ] && return 0
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
  printf '%-5s %-4s %-62s expected %s, got %s  %s\n' "${id}" "${CURRENT_CASE}" "${desc}" "${expected}" "${code}" \
    "$([ "${match}" = yes ] && echo OK || echo DIFFERS)"
}

# H1: the 401 on the vault comes from the API key, not from the user.
start_case H1
replay H1-1 201 "PUT /api/resources/7 as FOO (FOO is recognized)"   -X PUT -H "Authorization: FOO" "${S}/api/resources/7"
replay H1-2 401 "PUT /api/resources/8 without credentials"           -X PUT "${S}/api/resources/8"
replay H1-3 401 "POST /api/vault as FOO, wrong key"                   -X POST -H "Authorization: FOO" -H "X-Api-Key: nope" "${S}/api/vault"
replay H1-4 401 "POST /api/vault as BAR, same wrong key"              -X POST -H "Authorization: BAR" -H "X-Api-Key: nope" "${S}/api/vault"
replay H1-5 204 "POST /api/vault as FOO, key k3y"                     -X POST -H "Authorization: FOO" -H "X-Api-Key: k3y" "${S}/api/vault"

# H1c: same app and schema, but the vault's 401 depends on the user only.
start_case H1c
replay H1c-1 201 "PUT /api/resources/7 as FOO (FOO is recognized)"  -X PUT -H "Authorization: FOO" "${S}/api/resources/7"
replay H1c-2 401 "POST /api/vault as FOO, wrong key"                  -X POST -H "Authorization: FOO" -H "X-Api-Key: nope" "${S}/api/vault"
replay H1c-3 401 "POST /api/vault as FOO, key k3y"                    -X POST -H "Authorization: FOO" -H "X-Api-Key: k3y" "${S}/api/vault"
replay H1c-4 204 "POST /api/vault as BAR, wrong key"                  -X POST -H "Authorization: BAR" -H "X-Api-Key: nope" "${S}/api/vault"

# H2: every configured (recognized) user gets 401 on the admin endpoint.
start_case H2
replay H2-1 201 "PUT /api/resources/7 as FOO (FOO is recognized)"   -X PUT -H "Authorization: FOO" "${S}/api/resources/7"
replay H2-2 201 "PUT /api/resources/8 as BAR (BAR is recognized)"   -X PUT -H "Authorization: BAR" "${S}/api/resources/8"
replay H2-3 401 "DELETE /api/admin/cache as FOO"                      -X DELETE -H "Authorization: FOO" "${S}/api/admin/cache"
replay H2-4 401 "DELETE /api/admin/cache as BAR"                      -X DELETE -H "Authorization: BAR" "${S}/api/admin/cache"

# H4: ZED's credentials are not accepted anywhere; the catalog is public.
start_case H4
replay H4-1 401 "PUT /api/resources/7 as ZED (ZED not recognized)"  -X PUT -H "Authorization: ZED" "${S}/api/resources/7"
replay H4-2 201 "PUT /api/resources/7 as FOO"                         -X PUT -H "Authorization: FOO" "${S}/api/resources/7"
replay H4-3 200 "GET /api/catalog?region=eu as ZED"                   -H "Authorization: ZED" "${S}/api/catalog?region=eu"
replay H4-4 200 "GET /api/catalog?region=eu without credentials"      "${S}/api/catalog?region=eu"
replay H4-5 403 "GET /api/catalog?region=restricted as FOO"           -H "Authorization: FOO" "${S}/api/catalog?region=restricted"

docker rm -f a3-synth > /dev/null 2>&1
echo
echo "Summary: ${MATCHED} of ${TOTAL} replays matched the expected status."
[ "${MATCHED}" = "${TOTAL}" ]
