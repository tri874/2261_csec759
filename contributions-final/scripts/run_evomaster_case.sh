#!/bin/bash
# run_evomaster_case.sh
#
# Runs EvoMaster in black-box mode against any small target (used for the
# Assignment 2 case K), RUNS times with seeds 1..RUNS. Same EvoMaster image
# and options as run_evomaster_webgoat.sh, without the WebGoat-specific checks.
#
# Required environment variables:
#   CASE_DIR      folder holding the schema and auth config (mounted into EvoMaster)
#   SPEC_FILE     OpenAPI schema file name inside CASE_DIR
#   CONFIG_FILE   auth config file name inside CASE_DIR
#   TARGET        target host root, e.g. http://localhost:8081
#   RESULTS_ROOT  output folder
#
# Optional:
#   MAX_TIME         search budget per run   (default: 5m)
#   RUNS             number of repetitions   (default: 3)
#   STAT_ID          statisticsColumnId      (default: name of CASE_DIR)
#   RESET_CMD        shell command run before each run to reset the target's
#                    state; it must return once the target answers again
#   EXTRA_ARGS       extra EvoMaster options, space-separated
#   KEEP_GOING       1: after a failed run (exit status != 0 or no 2xx), keep its
#                    output and continue with the next run instead of stopping (A3)
#   EVOMASTER_IMAGE  EvoMaster Docker image  (default: same pinned 6.2.0 image)

set -euo pipefail

: "${CASE_DIR:?set CASE_DIR}" "${SPEC_FILE:?set SPEC_FILE}" "${CONFIG_FILE:?set CONFIG_FILE}"
: "${TARGET:?set TARGET}" "${RESULTS_ROOT:?set RESULTS_ROOT}"

CASE_DIR="$(cd "${CASE_DIR}" && pwd)"
MAX_TIME="${MAX_TIME:-5m}"
RUNS="${RUNS:-3}"
STAT_ID="${STAT_ID:-$(basename "${CASE_DIR}")}"
TARGET="${TARGET%/}"
EVOMASTER_IMAGE="${EVOMASTER_IMAGE:-webfuzzing/evomaster@sha256:de1f4387e809a309a4c61517f3340c3d0b733b78bbb86d0e3ebd217d343515ab}"
read -r -a EXTRA_ARGS_ARR <<< "${EXTRA_ARGS:-}"

for f in "${SPEC_FILE}" "${CONFIG_FILE}"; do
  if [ ! -f "${CASE_DIR}/${f}" ]; then
    echo "ERROR: ${CASE_DIR}/${f} not found"
    exit 1
  fi
done

if [ "$(curl -s -o /dev/null -w '%{http_code}' "${TARGET}/" || true)" = "000" ]; then
  echo "ERROR: nothing answers at ${TARGET} -- is the target running?"
  exit 1
fi

if [ -f "${RESULTS_ROOT}/run_1/statistics.csv" ]; then
  echo "ERROR: ${RESULTS_ROOT} already contains runs. Move them or set RESULTS_ROOT to a new folder."
  exit 1
fi
mkdir -p "${RESULTS_ROOT}"
# docker -v treats a relative path as a named volume, so mount by absolute path.
RESULTS_ROOT="$(cd "${RESULTS_ROOT}" && pwd)"

# A3: a locally built image (the prototype) is not in a registry, so only
# pull when the image is missing.
docker image inspect "${EVOMASTER_IMAGE}" > /dev/null 2>&1 || docker pull "${EVOMASTER_IMAGE}"
{
  echo "date_utc: $(date -u +%Y-%m-%dT%H:%M:%SZ)"
  echo "max_time: ${MAX_TIME}"
  echo "runs: ${RUNS}"
  echo "target: ${TARGET}"
  echo "case_dir: ${CASE_DIR}"
  echo "spec_file: ${SPEC_FILE}"
  echo "auth_config: ${CONFIG_FILE}"
  echo "extra_args: ${EXTRA_ARGS:-}"
  echo "reset_cmd: ${RESET_CMD:-}"
  echo "evomaster_image: ${EVOMASTER_IMAGE}"
  echo "evomaster_digest: $(docker image inspect --format '{{index .RepoDigests 0}}' "${EVOMASTER_IMAGE}" 2>/dev/null || echo unknown)"
  echo "evomaster_image_id: $(docker image inspect --format '{{.Id}}' "${EVOMASTER_IMAGE}" 2>/dev/null || echo unknown)"
  echo "docker_version: $(docker version --format '{{.Server.Version}}' 2>/dev/null || echo unknown)"
  echo "host: $(uname -srm)"
} > "${RESULTS_ROOT}/environment.txt"

for i in $(seq 1 "${RUNS}"); do
  echo "=== ${STAT_ID}: run ${i}/${RUNS} ==="
  RUN_DIR="${RESULTS_ROOT}/run_${i}"
  mkdir -p "${RUN_DIR}"

  if [ -n "${RESET_CMD:-}" ]; then
    echo "resetting target: ${RESET_CMD}"
    bash -c "${RESET_CMD}"
  fi

  # Record start/end time and EvoMaster's exit status for this run (raw/ metadata).
  RUN_START="$(date -u +%Y-%m-%dT%H:%M:%SZ)"
  set +e
  docker run --rm --network host \
    -v "${CASE_DIR}:/em/config" \
    -v "${RUN_DIR}:/em/generated_tests" \
    "${EVOMASTER_IMAGE}" \
    --blackBox true \
    --problemType REST \
    --bbSwaggerUrl "file:///em/config/${SPEC_FILE}" \
    --bbTargetUrl "${TARGET}" \
    --outputFormat KOTLIN_JUNIT_5 \
    --maxTime "${MAX_TIME}" \
    --outputFolder /em/generated_tests \
    --configPath "/em/config/${CONFIG_FILE}" \
    --seed "${i}" \
    --writeStatistics true \
    --statisticsColumnId "${STAT_ID}" \
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

  COVERED_2XX="$(python3 -c '
import csv, sys
row = next(csv.DictReader(open(sys.argv[1])), {})
print(row.get("covered2xx", "0") or "0")
' "${RUN_DIR}/statistics.csv" 2>/dev/null || echo 0)"
  if [ "${COVERED_2XX}" = "0" ]; then
    echo "ERROR: run ${i} got no 2xx responses from any endpoint -- check TARGET and ${CONFIG_FILE}."
    if [ "${KEEP_GOING:-0}" = "1" ]; then
      echo "KEEP_GOING=1: continuing with the next run" ; continue
    fi
    exit 1
  fi

  echo "=== ${STAT_ID}: run ${i}/${RUNS} done (endpoints with 2xx: ${COVERED_2XX}) ==="
done

echo "All ${RUNS} ${STAT_ID} runs complete. Results under ${RESULTS_ROOT}"
