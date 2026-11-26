#!/bin/bash
# run_evomaster_webgoat.sh
#
# Runs EvoMaster in black-box mode against WebGoat, RUNS times with seeds
# 1..RUNS, matching the ISSRE 2025 paper's RQ2 setup (black-box, 1 hour per
# run, 10 repetitions).
#
# Assumes:
#   - WebGoat is already running (see environment/setup.md)
#   - two WebGoat accounts exist that match environment/config/webgoat-em.yaml
#   - Linux host: EvoMaster reaches WebGoat on localhost via --network host
#
# Settings can be overridden with environment variables:
#   MAX_TIME         search budget per run          (default: 1h, as in the paper)
#   RUNS             number of repetitions          (default: 10)
#   RESULTS_ROOT     output folder                  (default: raw/webgoat)
#   EVOMASTER_IMAGE  EvoMaster Docker image         (default: the EvoMaster 6.2.0
#                    image used for the raw/webgoat baseline; set to
#                    webfuzzing/evomaster for the latest release)
#   WEBGOAT_TARGET   WebGoat host root, WITHOUT the /WebGoat base path
#                    (default: http://localhost:8080)
#   CONFIG_FILE      auth config file name inside environment/config/
#                    (default: webgoat-em.yaml)
#   EXTRA_ARGS       extra EvoMaster options, space-separated
#   KEEP_GOING       1: after a failed run (exit status != 0 or no 2xx), keep its
#                    output and continue with the next run instead of stopping (A3)
#                    (e.g. "--endpointPrefix /JWT")
#
# Example (short smoke test):
#   MAX_TIME=2m RUNS=1 RESULTS_ROOT=raw/smoke scripts/run_evomaster_webgoat.sh

set -euo pipefail

REPO_ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
CONFIG_DIR="${REPO_ROOT}/environment/config"
CONFIG_FILE="${CONFIG_FILE:-webgoat-em.yaml}"
SPEC_FILE="webgoat-spec.json"

MAX_TIME="${MAX_TIME:-1h}"
RUNS="${RUNS:-10}"
RESULTS_ROOT="${RESULTS_ROOT:-${REPO_ROOT}/raw/webgoat}"
read -r -a EXTRA_ARGS_ARR <<< "${EXTRA_ARGS:-}"
EVOMASTER_IMAGE="${EVOMASTER_IMAGE:-webfuzzing/evomaster@sha256:de1f4387e809a309a4c61517f3340c3d0b733b78bbb86d0e3ebd217d343515ab}"

# The schema's server URL (http://localhost:8080/WebGoat) already adds the
# /WebGoat base path to every endpoint EvoMaster generates, so the target must
# be the host root. Passing .../WebGoat here doubles the path
# (/WebGoat/WebGoat/...) and every request returns 302 or 404.
WEBGOAT_TARGET="${WEBGOAT_TARGET:-http://localhost:8080}"
WEBGOAT_TARGET="${WEBGOAT_TARGET%/}"

# The committed schema is the one used for the experiment, so every run uses the
# same endpoint list. It came from WebFuzzing/Dataset (openapi-swagger/).
if [ ! -f "${CONFIG_DIR}/${SPEC_FILE}" ]; then
  echo "ERROR: schema not found at ${CONFIG_DIR}/${SPEC_FILE}"
  exit 1
fi

if [ ! -f "${CONFIG_DIR}/${CONFIG_FILE}" ]; then
  echo "ERROR: ${CONFIG_DIR}/${CONFIG_FILE} not found -- create the auth config before running."
  exit 1
fi

SPEC_BASE_PATH="$(python3 -c '
import json, sys, urllib.parse
spec = json.load(open(sys.argv[1]))
servers = spec.get("servers") or [{"url": ""}]
print(urllib.parse.urlparse(servers[0]["url"]).path.rstrip("/"))
' "${CONFIG_DIR}/${SPEC_FILE}")"

if [ -n "${SPEC_BASE_PATH}" ] && [ "${WEBGOAT_TARGET%"${SPEC_BASE_PATH}"}" != "${WEBGOAT_TARGET}" ]; then
  echo "ERROR: WEBGOAT_TARGET (${WEBGOAT_TARGET}) already ends with the schema's base path (${SPEC_BASE_PATH})."
  echo "       EvoMaster adds ${SPEC_BASE_PATH} itself; use the host root, e.g. http://localhost:8080"
  exit 1
fi

LOGIN_URL="${WEBGOAT_TARGET}${SPEC_BASE_PATH}/login"
if ! curl -sf -o /dev/null "${LOGIN_URL}"; then
  echo "ERROR: cannot reach ${LOGIN_URL} -- is WebGoat running on this host/port?"
  exit 1
fi

if [ -f "${RESULTS_ROOT}/run_1/statistics.csv" ]; then
  echo "ERROR: ${RESULTS_ROOT} already contains runs. Move them or set RESULTS_ROOT to a new folder."
  exit 1
fi
mkdir -p "${RESULTS_ROOT}"
# docker -v treats a relative path as a named volume, so mount by absolute path.
RESULTS_ROOT="$(cd "${RESULTS_ROOT}" && pwd)"

# Pull once so all runs use the same image, then record exact versions.
# A3: a locally built image (the prototype) is not in a registry, so only
# pull when the image is missing.
docker image inspect "${EVOMASTER_IMAGE}" > /dev/null 2>&1 || docker pull "${EVOMASTER_IMAGE}"
{
  echo "date_utc: $(date -u +%Y-%m-%dT%H:%M:%SZ)"
  echo "max_time: ${MAX_TIME}"
  echo "runs: ${RUNS}"
  echo "webgoat_target: ${WEBGOAT_TARGET}"
  echo "auth_config: ${CONFIG_FILE}"
  echo "extra_args: ${EXTRA_ARGS:-}"
  echo "schema_base_path: ${SPEC_BASE_PATH}"
  echo "evomaster_image: ${EVOMASTER_IMAGE}"
  echo "evomaster_digest: $(docker image inspect --format '{{index .RepoDigests 0}}' "${EVOMASTER_IMAGE}" 2>/dev/null || echo unknown)"
  echo "evomaster_image_id: $(docker image inspect --format '{{.Id}}' "${EVOMASTER_IMAGE}" 2>/dev/null || echo unknown)"
  echo "webgoat_container_image: $(docker inspect --format '{{.Config.Image}}' webgoat 2>/dev/null || echo unknown)"
  echo "webgoat_image_id: $(docker inspect --format '{{.Image}}' webgoat 2>/dev/null || echo unknown)"
  echo "webgoat_digest: $(docker image inspect --format '{{index .RepoDigests 0}}' "$(docker inspect --format '{{.Image}}' webgoat 2>/dev/null)" 2>/dev/null || echo unknown)"
  echo "docker_version: $(docker version --format '{{.Server.Version}}' 2>/dev/null || echo unknown)"
  echo "host: $(uname -srm)"
} > "${RESULTS_ROOT}/environment.txt"

for i in $(seq 1 "${RUNS}"); do
  echo "=== webgoat: run ${i}/${RUNS} ==="
  RUN_DIR="${RESULTS_ROOT}/run_${i}"
  mkdir -p "${RUN_DIR}"

  # Record start/end time and EvoMaster's exit status for this run (raw/ metadata).
  RUN_START="$(date -u +%Y-%m-%dT%H:%M:%SZ)"
  set +e
  docker run --rm --network host \
    -v "${CONFIG_DIR}:/em/config" \
    -v "${RUN_DIR}:/em/generated_tests" \
    "${EVOMASTER_IMAGE}" \
    --blackBox true \
    --problemType REST \
    --bbSwaggerUrl "file:///em/config/${SPEC_FILE}" \
    --bbTargetUrl "${WEBGOAT_TARGET}" \
    --outputFormat KOTLIN_JUNIT_5 \
    --maxTime "${MAX_TIME}" \
    --outputFolder /em/generated_tests \
    --configPath "/em/config/${CONFIG_FILE}" \
    --seed "${i}" \
    --writeStatistics true \
    --statisticsColumnId "webgoat" \
    --statisticsFile "/em/generated_tests/statistics.csv" \
    --appendToStatisticsFile false \
    ${EXTRA_ARGS_ARR[@]+"${EXTRA_ARGS_ARR[@]}"} \
    2>&1 | tee "${RUN_DIR}/evomaster_stdout.log"
  RUN_EXIT="${PIPESTATUS[0]}"
  set -e
  {
    echo "run: ${i}"
    echo "seed: ${i}"
    echo "start_utc: ${RUN_START}"
    echo "end_utc: $(date -u +%Y-%m-%dT%H:%M:%SZ)"
    echo "exit_status: ${RUN_EXIT}"
  } > "${RUN_DIR}/run_meta.txt"
  if [ "${RUN_EXIT}" != "0" ]; then
    echo "ERROR: EvoMaster exited with status ${RUN_EXIT} in run ${i}; output kept in ${RUN_DIR}"
    if [ "${KEEP_GOING:-0}" = "1" ]; then
      echo "KEEP_GOING=1: continuing with the next run" ; continue
    fi
    exit "${RUN_EXIT}"
  fi

  # Stop early if nothing succeeded: 0 endpoints with a 2xx response means the
  # target URL or the logins are wrong, and the remaining runs would be wasted.
  COVERED_2XX="$(python3 -c '
import csv, sys
row = next(csv.DictReader(open(sys.argv[1])), {})
print(row.get("covered2xx", "0") or "0")
' "${RUN_DIR}/statistics.csv" 2>/dev/null || echo 0)"
  if [ "${COVERED_2XX}" = "0" ]; then
    echo "ERROR: run ${i} got no 2xx responses from any endpoint -- check WEBGOAT_TARGET and the accounts in ${CONFIG_FILE}."
    if [ "${KEEP_GOING:-0}" = "1" ]; then
      echo "KEEP_GOING=1: continuing with the next run" ; continue
    fi
    exit 1
  fi

  echo "=== webgoat: run ${i}/${RUNS} done (endpoints with 2xx: ${COVERED_2XX}) ==="
done

echo "All ${RUNS} webgoat runs complete. Results under ${RESULTS_ROOT}"
