#!/bin/bash
# a3_run_all.sh
#
# Runs the Assignment 3 pilot (cases/README.md, predictions in
# notes/a3_predictions.md): every case under each EvoMaster configuration
# ("variant"), then the deterministic replays and the results table.
#
# Variants (same options apart from the ones listed):
#   baseline  official EvoMaster 6.2.0 image (the A1/A2 baseline), no new options
#   proto     prototype image, both rules:  --notRecognizedCredentialEvidence true
#                                           --notRecognizedUserAttribution true
#   rule1     prototype image, Rule 1 only (ablation)
#   rule2     prototype image, Rule 2 only (ablation)
#   forkoff   prototype image, both rules off (checks that our build behaves
#             like the official image)
#
# Cases:
#   synthetic (target restarted before every run, budget SYNTH_TIME):
#     K    regression: A2 known working example (true fault)
#     H1   variant: second credential (API key), genuine login evidence (no fault)
#     H1c  matched control of H1: the 401 depends on the user (true fault)
#     H2   tradeoff: role-restricted endpoint, 401 for every user (true fault)
#     H4   Rule 1 mechanism case: misconfigured user (no fault)
#   WebGoat (restarted before every case/variant block, budget WG_TIME):
#     P      primary A2 failed case (JWT lesson, 5 false alarms)
#     C-alt  matched control of P (A2): users also send an Authorization header
#
# Environment variables:
#   MODE     full (default): the plan below, 3 runs each, into raw/a3/
#            smoke: K and H1 under baseline and proto, 1 run x 1 min, into
#                   raw/a3_smoke/ (setup check only, not reported)
#   PLAN     override the list of "variant:case" items to run
#   STEPS    default "runs replays table"
#   RUNS, SYNTH_TIME, WG_TIME, ROOT   override the MODE defaults
#   PROTO_IMAGE  default: the "image:" line of environment/a3_build.txt
#
# Example:
#   mkdir -p logs && scripts/a3_run_all.sh 2>&1 | tee logs/a3_full.log

set -euo pipefail

REPO_ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
cd "${REPO_ROOT}"

BASELINE_IMAGE="webfuzzing/evomaster@sha256:de1f4387e809a309a4c61517f3340c3d0b733b78bbb86d0e3ebd217d343515ab"
PROTO_IMAGE="${PROTO_IMAGE:-$(awk '$1 == "image:" {print $2}' environment/a3_build.txt 2>/dev/null || true)}"

MODE="${MODE:-full}"
if [ "${MODE}" = "smoke" ]; then
  RUNS="${RUNS:-1}"; SYNTH_TIME="${SYNTH_TIME:-1m}"; WG_TIME="${WG_TIME:-1m}"; ROOT="${ROOT:-raw/a3_smoke}"
  DEFAULT_PLAN="baseline:K proto:K baseline:H1 proto:H1"
else
  RUNS="${RUNS:-3}"; SYNTH_TIME="${SYNTH_TIME:-2m}"; WG_TIME="${WG_TIME:-5m}"; ROOT="${ROOT:-raw/a3}"
  # Main comparison (baseline vs proto) on every case, then the ablations,
  # then the build check. Grouped by case so each target is set up once.
  DEFAULT_PLAN="baseline:K proto:K forkoff:K
                baseline:H1 proto:H1 rule1:H1 rule2:H1
                baseline:H1c proto:H1c
                baseline:H2 proto:H2
                baseline:H4 proto:H4 rule1:H4 rule2:H4
                baseline:P proto:P rule1:P rule2:P forkoff:P
                baseline:C-alt proto:C-alt"
fi
PLAN="${PLAN:-${DEFAULT_PLAN}}"
STEPS="${STEPS:-runs replays table}"
export RUNS

WEBGOAT="http://localhost:8080"
K_URL="http://localhost:8081"
S_URL="http://localhost:8082"

log() { echo; echo "##### $(date -u +%Y-%m-%dT%H:%M:%SZ) $*"; }

wait_for() { # URL SECONDS
  local url="$1" secs="$2"
  for _ in $(seq "${secs}"); do
    [ "$(curl -s -o /dev/null -w '%{http_code}' "${url}" || true)" != "000" ] && return 0
    sleep 1
  done
  echo "ERROR: ${url} did not come up within ${secs}s"
  exit 1
}

image_for() { # VARIANT
  case "$1" in
    baseline) echo "${BASELINE_IMAGE}" ;;
    proto|rule1|rule2|forkoff)
      if [ -z "${PROTO_IMAGE}" ]; then
        echo "ERROR: no prototype image; run scripts/a3_build_fork.sh or set PROTO_IMAGE" >&2
        exit 1
      fi
      echo "${PROTO_IMAGE}" ;;
    *) echo "ERROR: unknown variant $1" >&2; exit 1 ;;
  esac
}

rule_args() { # VARIANT
  case "$1" in
    proto)   echo "--notRecognizedCredentialEvidence true --notRecognizedUserAttribution true" ;;
    rule1)   echo "--notRecognizedCredentialEvidence true --notRecognizedUserAttribution false" ;;
    rule2)   echo "--notRecognizedCredentialEvidence false --notRecognizedUserAttribution true" ;;
    forkoff) echo "--notRecognizedCredentialEvidence false --notRecognizedUserAttribution false" ;;
    *)       echo "" ;;
  esac
}

restart_webgoat() {
  log "restarting WebGoat (accounts kept in the webgoat_data volume)"
  docker restart webgoat > /dev/null
  wait_for "${WEBGOAT}/WebGoat/login" 300
  sleep 10
}

start_k() {
  docker build -q -t a2-k cases/k_notrecognized > /dev/null
  docker rm -f a2-k > /dev/null 2>&1 || true
  docker run -d --name a2-k -p 127.0.0.1:8081:8081 a2-k > /dev/null
  wait_for "${K_URL}/api/resources/1" 60
}

start_synth() { # CASE (H1, H1c, H2, H4)
  docker build -q -t a3-synth cases/a3_synthetic_app > /dev/null
  docker rm -f a3-synth > /dev/null 2>&1 || true
  docker run -d --name a3-synth -e "CASE=$1" -p 127.0.0.1:8082:8082 a3-synth > /dev/null
  wait_for "${S_URL}/api/resources/1" 60
}

synth_dir() {
  case "$1" in
    H1) echo cases/H1_apikey ;;
    H1c) echo cases/H1c_apikey_userbug ;;
    H2) echo cases/H2_role ;;
    H4) echo cases/H4_misconfigured_user ;;
  esac
}

# Records every attempted item and its exit status, so failed items stay visible.
ITEMS_CSV=""

run_item() { # VARIANT CASE
  local variant="$1" case_id="$2" image extra out status
  image="$(image_for "${variant}")"
  extra="$(rule_args "${variant}")"
  out="${ROOT}/${variant}/${case_id}"
  log "item ${variant}:${case_id}: ${RUNS} run(s), image ${image}, args: ${extra}"
  if [ -f "${out}/run_1/statistics.csv" ]; then
    echo "skipping: ${out} already has runs"
    echo "${variant},${case_id},skipped_existing,$(date -u +%Y-%m-%dT%H:%M:%SZ)" >> "${ITEMS_CSV}"
    return 0
  fi
  set +e
  case "${case_id}" in
    K)
      start_k
      CASE_DIR=cases/k_notrecognized SPEC_FILE=openapi.json CONFIG_FILE=k-em.yaml \
        TARGET="${K_URL}" RESULTS_ROOT="${out}" STAT_ID="${variant}-K" MAX_TIME="${SYNTH_TIME}" \
        EVOMASTER_IMAGE="${image}" EXTRA_ARGS="${extra}" KEEP_GOING=1 \
        RESET_CMD="docker restart a2-k >/dev/null && for i in \$(seq 60); do [ \"\$(curl -s -o /dev/null -w '%{http_code}' ${K_URL}/api/resources/1)\" != 000 ] && exit 0; sleep 1; done; exit 1" \
        scripts/run_evomaster_case.sh
      status=$? ;;
    H1|H1c|H2|H4)
      start_synth "${case_id}"
      CASE_DIR="$(synth_dir "${case_id}")" SPEC_FILE=openapi.json CONFIG_FILE=em.yaml \
        TARGET="${S_URL}" RESULTS_ROOT="${out}" STAT_ID="${variant}-${case_id}" MAX_TIME="${SYNTH_TIME}" \
        EVOMASTER_IMAGE="${image}" EXTRA_ARGS="${extra}" KEEP_GOING=1 \
        RESET_CMD="docker restart a3-synth >/dev/null && for i in \$(seq 60); do [ \"\$(curl -s -o /dev/null -w '%{http_code}' ${S_URL}/api/resources/1)\" != 000 ] && exit 0; sleep 1; done; exit 1" \
        scripts/run_evomaster_case.sh
      status=$? ;;
    P|C-alt)
      local config=webgoat-em.yaml
      [ "${case_id}" = "C-alt" ] && config=webgoat-em-c-auth.yaml
      restart_webgoat
      CONFIG_FILE="${config}" EXTRA_ARGS="--endpointPrefix /JWT ${extra}" RESULTS_ROOT="${out}" \
        MAX_TIME="${WG_TIME}" EVOMASTER_IMAGE="${image}" KEEP_GOING=1 \
        scripts/run_evomaster_webgoat.sh
      status=$?
      [ -d "${out}" ] && cp "environment/config/${config}" "${out}/auth-config.yaml" ;;
    *) echo "ERROR: unknown case ${case_id}"; status=2 ;;
  esac
  set -e
  echo "${variant},${case_id},exit_${status},$(date -u +%Y-%m-%dT%H:%M:%SZ)" >> "${ITEMS_CSV}"
  [ "${status}" = "0" ] || echo "WARNING: item ${variant}:${case_id} ended with status ${status}; continuing"
}

mkdir -p "${ROOT}"
ITEMS_CSV="${ROOT}/items.csv"
[ -f "${ITEMS_CSV}" ] || echo "variant,case,status,end_utc" > "${ITEMS_CSV}"

for step in ${STEPS}; do
  case "${step}" in
    runs)
      log "plan (mode ${MODE}, ${RUNS} run(s), synthetic ${SYNTH_TIME}, WebGoat ${WG_TIME}): ${PLAN//$'\n'/ }"
      for item in ${PLAN}; do
        run_item "${item%%:*}" "${item#*:}"
      done
      docker rm -f a3-synth > /dev/null 2>&1 || true
      ;;
    replays)
      log "deterministic replays (ground truth of the synthetic cases, A2 replays for WebGoat and K)"
      docker ps --format '{{.Names}}' | grep -qx a2-k || start_k
      OUT_DIR="${ROOT}/replays" scripts/a3_replays.sh || echo "WARNING: some A3 replays differ"
      OUT_DIR="${ROOT}/replays_a2" scripts/a2_replays.sh || echo "WARNING: some A2 replays differ"
      ;;
    table)
      log "results table"
      python3 scripts/a3_table.py "${ROOT}"
      ;;
    *) echo "ERROR: unknown step ${step}"; exit 1 ;;
  esac
done

log "done: ${STEPS} (mode ${MODE}, results in ${ROOT})"
