#!/bin/bash
# final_run_all.sh
#
# Runs the final-project evaluation (notes/final_plan.md, predictions in
# notes/final_predictions.md): items "variant:case[:runs]", grouped so they can
# be run overnight one group at a time, then the replays and the table.
#
# Variants (same options apart from the ones listed):
#   baseline  official EvoMaster 6.2.0 image (the A1-A3 baseline)
#   proto     final image, both rules on
#   rule1     final image, Rule 1 only (ablation)
#   rule2     final image, Rule 2 only (ablation)
#   forkoff   final image, both rules off: behaves like the baseline (A3 check
#             on P and K) and, unlike the official image, logs the cost of the
#             Not-Recognized step, so it is the cost reference
#
# Cases:
#   H5 H6 H7 H8  held-out synthetic cases (cases/final_synthetic_app), budget SYNTH_TIME
#   crapi        OWASP crAPI v1.1.6 (cases/crapi), reset before every run, budget CRAPI_TIME,
#                credential-changing endpoints excluded (CRAPI_EXCLUDE, notes/final_decisions.md D4)
#   wgfull       WebGoat, full API (no endpoint prefix), budget WG_TIME; the baseline
#                for it is A1's raw/webgoat (same image, VM, budget, seeds)
#   S<E>x<U>     generated scaling API with E protected endpoints and U users
#                (cases/final_scaling/E<E>_U<U>), budget SCALE_TIME
#
# Environment variables:
#   GROUP   synthetic | scaling | crapi | webgoat | smoke   (default: synthetic)
#   PLAN    override the item list of the group
#   STEPS   default "runs replays table"
#   ROOT    default raw/final (smoke: raw/final_smoke2)
#   FINAL_IMAGE  default: the "image:" line of environment/final_build.txt
#   SYNTH_TIME, CRAPI_TIME, WG_TIME, SCALE_TIME, RUNS (default runs per item)
#
# Example:
#   mkdir -p logs && GROUP=synthetic scripts/final_run_all.sh 2>&1 | tee logs/final_synthetic.log

set -euo pipefail

REPO_ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
cd "${REPO_ROOT}"

BASELINE_IMAGE="webfuzzing/evomaster@sha256:de1f4387e809a309a4c61517f3340c3d0b733b78bbb86d0e3ebd217d343515ab"
FINAL_IMAGE="${FINAL_IMAGE:-$(awk '$1 == "image:" {print $2}' environment/final_build.txt 2>/dev/null || true)}"

GROUP="${GROUP:-synthetic}"
SYNTH_TIME="${SYNTH_TIME:-2m}"; CRAPI_TIME="${CRAPI_TIME:-30m}"; WG_TIME="${WG_TIME:-1h}"; SCALE_TIME="${SCALE_TIME:-5m}"
RUNS="${RUNS:-3}"
ROOT="${ROOT:-raw/final}"

# Endpoints that change the configured users' credentials (password, email,
# OTP reset). With them, the first minute of a run invalidates both logins and
# every later 401 is self-inflicted (raw/final_smoke, notes/final_decisions.md D4).
CRAPI_EXCLUDE="/identity/api/v2/user/reset-password,/identity/api/v2/user/change-email,/identity/api/v2/user/verify-email-token,/identity/api/auth/forget-password,/identity/api/auth/v2/check-otp,/identity/api/auth/v3/check-otp"

case "${GROUP}" in
  synthetic)
    DEFAULT_PLAN="baseline:H5 proto:H5 rule1:H5 rule2:H5
                  baseline:H6 proto:H6 rule1:H6 rule2:H6
                  baseline:H7 proto:H7 rule1:H7 rule2:H7
                  baseline:H8 proto:H8 rule1:H8 rule2:H8" ;;
  scaling)
    DEFAULT_PLAN=""
    for e in 5 10 20 40; do for u in 2 4 8; do
      DEFAULT_PLAN="${DEFAULT_PLAN} forkoff:S${e}x${u} proto:S${e}x${u}"
    done; done ;;
  crapi)
    DEFAULT_PLAN="baseline:crapi:5 proto:crapi:5 rule1:crapi:3 rule2:crapi:3 forkoff:crapi:3" ;;
  webgoat)
    DEFAULT_PLAN="proto:wgfull:5" ;;
  smoke)
    ROOT="${ROOT/#raw\/final/raw/final_smoke2}"
    SYNTH_TIME=1m; CRAPI_TIME=5m; SCALE_TIME=1m; WG_TIME=2m
    DEFAULT_PLAN="proto:H6:1 proto:H7:1 forkoff:S5x2:1 proto:S5x2:1 baseline:crapi:1 proto:crapi:1" ;;
  *) echo "ERROR: unknown GROUP ${GROUP}"; exit 1 ;;
esac
PLAN="${PLAN:-${DEFAULT_PLAN}}"
STEPS="${STEPS:-runs replays table}"

S_URL="http://localhost:8083"
SCALE_URL="http://localhost:8084"
CRAPI_URL="http://localhost:8888"
WEBGOAT="http://localhost:8080"

log() { echo; echo "##### $(date -u +%Y-%m-%dT%H:%M:%SZ) $*"; }

wait_for() { # URL SECONDS
  local url="$1" secs="$2"
  for _ in $(seq "${secs}"); do
    [ "$(curl -s -o /dev/null -w '%{http_code}' "${url}" || true)" != "000" ] && return 0
    sleep 1
  done
  echo "ERROR: ${url} did not come up within ${secs}s"
  return 1
}

image_for() { # VARIANT
  case "$1" in
    baseline) echo "${BASELINE_IMAGE}" ;;
    proto|rule1|rule2|forkoff)
      if [ -z "${FINAL_IMAGE}" ]; then
        echo "ERROR: no final image; run the final build (README) or set FINAL_IMAGE" >&2
        exit 1
      fi
      echo "${FINAL_IMAGE}" ;;
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

synth_dir() {
  case "$1" in
    H5) echo cases/H5_second_scheme ;;
    H6) echo cases/H6_redirect_login ;;
    H7) echo cases/H7_creating_post ;;
    H8) echo cases/H8_three_users ;;
  esac
}

# The reset commands run before every run (run_evomaster_case.sh RESET_CMD).
SYNTH_RESET="docker restart final-synth >/dev/null && for i in \$(seq 60); do [ \"\$(curl -s -o /dev/null -w '%{http_code}' ${S_URL}/login)\" != 000 ] && exit 0; sleep 1; done; exit 1"
SCALE_RESET="docker restart final-scale >/dev/null && for i in \$(seq 60); do [ \"\$(curl -s -o /dev/null -w '%{http_code}' ${SCALE_URL}/api/resources/1)\" != 000 ] && exit 0; sleep 1; done; exit 1"

ITEMS_CSV=""

run_item() { # VARIANT CASE [RUNS]
  local variant="$1" case_id="$2" runs="${3:-${RUNS}}" image extra out status
  image="$(image_for "${variant}")"
  extra="$(rule_args "${variant}")"
  out="${ROOT}/${variant}/${case_id}"
  log "item ${variant}:${case_id}: ${runs} run(s), image ${image}, args: ${extra}"
  if [ -f "${out}/run_1/statistics.csv" ]; then
    echo "skipping: ${out} already has runs"
    echo "${variant},${case_id},skipped_existing,$(date -u +%Y-%m-%dT%H:%M:%SZ)" >> "${ITEMS_CSV}"
    return 0
  fi
  set +e
  case "${case_id}" in
    H5|H6|H7|H8)
      docker build -q -t final-synth cases/final_synthetic_app > /dev/null
      docker rm -f final-synth > /dev/null 2>&1
      docker run -d --name final-synth -e "CASE=${case_id}" -p 127.0.0.1:8083:8083 final-synth > /dev/null
      wait_for "${S_URL}/login" 60 &&
      RUNS="${runs}" CASE_DIR="$(synth_dir "${case_id}")" SPEC_FILE=openapi.json CONFIG_FILE=em.yaml \
        TARGET="${S_URL}" RESULTS_ROOT="${out}" STAT_ID="${variant}-${case_id}" MAX_TIME="${SYNTH_TIME}" \
        EVOMASTER_IMAGE="${image}" EXTRA_ARGS="${extra}" KEEP_GOING=1 RESET_CMD="${SYNTH_RESET}" \
        scripts/run_evomaster_case.sh
      status=$? ;;
    S*x*)
      local e u cell
      e="${case_id#S}"; e="${e%x*}"; u="${case_id#*x}"; cell="cases/final_scaling/E${e}_U${u}"
      [ -d "${cell}" ] || python3 scripts/final_gen_scaling.py "${e}" "${u}" > /dev/null
      docker build -q -t final-scale cases/final_scaling_app > /dev/null
      docker rm -f final-scale > /dev/null 2>&1
      docker run -d --name final-scale -e "E=${e}" -e "U=${u}" -p 127.0.0.1:8084:8084 final-scale > /dev/null
      wait_for "${SCALE_URL}/api/resources/1" 60 &&
      RUNS="${runs}" CASE_DIR="${cell}" SPEC_FILE=openapi.json CONFIG_FILE=em.yaml \
        TARGET="${SCALE_URL}" RESULTS_ROOT="${out}" STAT_ID="${variant}-${case_id}" MAX_TIME="${SCALE_TIME}" \
        EVOMASTER_IMAGE="${image}" EXTRA_ARGS="${extra}" KEEP_GOING=1 RESET_CMD="${SCALE_RESET}" \
        scripts/run_evomaster_case.sh
      status=$? ;;
    crapi)
      scripts/final_crapi.sh reset &&
      RUNS="${runs}" CASE_DIR=cases/crapi SPEC_FILE=crapi-openapi-spec.json CONFIG_FILE=em.yaml \
        TARGET="${CRAPI_URL}" RESULTS_ROOT="${out}" STAT_ID="${variant}-crapi" MAX_TIME="${CRAPI_TIME}" \
        EVOMASTER_IMAGE="${image}" EXTRA_ARGS="--endpointExclude ${CRAPI_EXCLUDE} ${extra}" KEEP_GOING=1 \
        RESET_CMD="scripts/final_crapi.sh reset" \
        scripts/run_evomaster_case.sh
      status=$? ;;
    wgfull)
      log "restarting WebGoat (accounts kept in the webgoat_data volume)"
      docker restart webgoat > /dev/null && wait_for "${WEBGOAT}/WebGoat/login" 300 && sleep 10 &&
      RUNS="${runs}" CONFIG_FILE=webgoat-em.yaml EXTRA_ARGS="${extra}" RESULTS_ROOT="${out}" \
        MAX_TIME="${WG_TIME}" EVOMASTER_IMAGE="${image}" KEEP_GOING=1 \
        scripts/run_evomaster_webgoat.sh
      status=$? ;;
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
      log "group ${GROUP}, root ${ROOT}, default ${RUNS} run(s); budgets synthetic ${SYNTH_TIME}, crAPI ${CRAPI_TIME}, WebGoat ${WG_TIME}, scaling ${SCALE_TIME}"
      log "plan: ${PLAN//$'\n'/ }"
      for item in ${PLAN}; do
        IFS=: read -r v c n <<< "${item}"
        run_item "${v}" "${c}" "${n}"
      done
      docker rm -f final-synth final-scale > /dev/null 2>&1 || true
      case " ${PLAN} " in *":crapi"*) scripts/final_crapi.sh down > /dev/null 2>&1 || true ;; esac
      ;;
    replays)
      if [ "${GROUP}" = "synthetic" ] || [ "${GROUP}" = "smoke" ]; then
        log "deterministic replays of H5-H8"
        OUT_DIR="${ROOT}/replays" scripts/final_replays.sh || echo "WARNING: some replays differ"
      fi
      ;;
    table)
      log "results table"
      python3 scripts/final_table.py "${ROOT}" || echo "WARNING: table failed"
      ;;
    *) echo "ERROR: unknown step ${step}"; exit 1 ;;
  esac
done

log "done: group ${GROUP}, steps ${STEPS}, results in ${ROOT}"
