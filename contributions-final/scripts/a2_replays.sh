#!/bin/bash
# a2_replays.sh
#
# Deterministic replays for Assignment 2 (cases/README.md,
# predictions in notes/a2_predictions.md). Each replay is one curl request; the
# command, response headers, body and status code are saved under OUT_DIR, and
# a summary is written to OUT_DIR/replays.csv.
#
# Assumes WebGoat (with the two accounts from environment/config/webgoat-em.yaml)
# and the case K app are both running.
#
# Optional environment variables:
#   WEBGOAT_URL  default http://localhost:8080
#   K_URL        default http://localhost:8081
#   OUT_DIR      default raw/a2/replays

set -uo pipefail

REPO_ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
WG="${WEBGOAT_URL:-http://localhost:8080}/WebGoat"
K="${K_URL:-http://localhost:8081}"
OUT_DIR="${OUT_DIR:-${REPO_ROOT}/raw/a2/replays}"
mkdir -p "${OUT_DIR}"
OUT_DIR="$(cd "${OUT_DIR}" && pwd)"
CSV="${OUT_DIR}/replays.csv"
JARS="$(mktemp -d)"
trap 'rm -rf "${JARS}"' EXIT

echo "id,request,expected,observed,match" > "${CSV}"
{
  echo "date_utc: $(date -u +%Y-%m-%dT%H:%M:%SZ)"
  echo "webgoat_url: ${WG}"
  echo "k_url: ${K}"
  echo "webgoat_image: $(docker inspect --format '{{.Image}}' webgoat 2>/dev/null || echo unknown)"
  echo "k_image: $(docker inspect --format '{{.Image}}' a2-k 2>/dev/null || echo unknown)"
} > "${OUT_DIR}/environment.txt"

# replay ID EXPECTED "description" curl-args...
replay() {
  local id="$1" expected="$2" desc="$3"
  shift 3
  local code
  printf 'curl' > "${OUT_DIR}/${id}.cmd"
  printf ' %q' "$@" >> "${OUT_DIR}/${id}.cmd"
  echo >> "${OUT_DIR}/${id}.cmd"
  code="$(curl -s -o "${OUT_DIR}/${id}.body" -D "${OUT_DIR}/${id}.headers" -w '%{http_code}' "$@")"
  local match="no"
  [ "${code}" = "${expected}" ] && match="yes"
  echo "${id},\"${desc}\",${expected},${code},${match}" >> "${CSV}"
  printf '%-4s %-72s expected %s, got %s  %s\n' "${id}" "${desc}" "${expected}" "${code}" \
    "$([ "${match}" = yes ] && echo OK || echo DIFFERS)"
}

# login JAR USER PASSWORD: fresh WebGoat session in a new cookie jar
login() {
  local jar="$1" user="$2" pass="$3" result
  rm -f "${jar}"
  result="$(curl -s -c "${jar}" -o /dev/null -w '%{http_code} %{redirect_url}' \
    -d "username=${user}&password=${pass}" "${WG}/login")"
  case "${result}" in
    302*error*|000*) echo "ERROR: login as ${user} failed (${result})"; exit 1 ;;
  esac
}

A="${JARS}/userA" B="${JARS}/userB"

echo "--- WebGoat: POST /JWT/votings/{title}"
replay R1 302 "POST /JWT/votings/a2 with no session" \
  -X POST "${WG}/JWT/votings/a2"
login "${A}" useraa userAA
replay R2 401 "POST /JWT/votings/a2 as userA" \
  -b "${A}" -X POST "${WG}/JWT/votings/a2"
login "${B}" userbb userBB
replay R3 401 "POST /JWT/votings/a2 as userB" \
  -b "${B}" -X POST "${WG}/JWT/votings/a2"
login "${A}" useraa userAA
replay R4-token 200 "GET /JWT/votings/login?user=Tom as userA (gets access_token)" \
  -b "${A}" -c "${A}" "${WG}/JWT/votings/login?user=Tom"
replay R4 202 "POST /JWT/votings/a2 as userA with Tom's access_token" \
  -b "${A}" -X POST "${WG}/JWT/votings/a2"

echo "--- WebGoat: GET /JWT/votings/login (lesson login)"
login "${A}" useraa userAA
replay R5a 200 "GET /JWT/votings/login?user=Tom as userA" \
  -b "${A}" "${WG}/JWT/votings/login?user=Tom"
login "${A}" useraa userAA
replay R5b 401 "GET /JWT/votings/login?user=zzz as userA" \
  -b "${A}" "${WG}/JWT/votings/login?user=zzz"

echo "--- WebGoat: POST /JWT/refresh/checkout"
login "${A}" useraa userAA
replay R6a 401 "POST /JWT/refresh/checkout as userA without Authorization" \
  -b "${A}" -X POST "${WG}/JWT/refresh/checkout"
replay R6b 200 "POST /JWT/refresh/checkout as userA with Authorization: Bearer a2-control" \
  -b "${A}" -X POST -H "Authorization: Bearer a2-control" "${WG}/JWT/refresh/checkout"

echo "--- Case K: POST /api/resources/"
replay R7a 401 "K: POST /api/resources/ as FOO" \
  -X POST -H "Authorization: FOO" "${K}/api/resources/"
replay R7b 204 "K: POST /api/resources/ as BAR" \
  -X POST -H "Authorization: BAR" "${K}/api/resources/"
replay R7c 401 "K: POST /api/resources/ with no Authorization" \
  -X POST "${K}/api/resources/"

echo
echo "Summary: $(grep -c ',yes$' "${CSV}") of $(( $(wc -l < "${CSV}") - 1 )) replays matched the prediction. Details in ${OUT_DIR}"
