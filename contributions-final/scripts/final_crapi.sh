#!/bin/bash
# final_crapi.sh
#
# Sets up, resets and checks OWASP crAPI v1.1.6 (final project, second real
# target; crAPI is one of the vulnerable-by-design APIs in the paper's RQ2).
#
# Usage:
#   scripts/final_crapi.sh setup   clone crAPI at tag v1.1.6, check the commit, pull the pinned images,
#                                  write environment/crapi_images.txt (image ids and digests)
#   scripts/final_crapi.sh up      start crAPI and wait until the API answers
#   scripts/final_crapi.sh reset   stop crAPI, delete its databases, start it again (fresh seed data)
#   scripts/final_crapi.sh check   log in as both configured users and call a few endpoints
#   scripts/final_crapi.sh down    stop crAPI and delete its databases
#
# The chatbot service (needs an OpenAI key, not in the schema) is not started.
# crAPI's web gateway listens on http://localhost:8888 (TLS off).
#
# Environment: CRAPI_DIR (default: ../crAPI next to this repository folder)

set -euo pipefail

REPO_ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
CRAPI_DIR="${CRAPI_DIR:-${REPO_ROOT}/../crAPI}"
CRAPI_TAG="v1.1.6"
CRAPI_COMMIT="700f03d12a392d9e408260b4beae72ed02a4a1a4"
CRAPI_URL="http://localhost:8888"
SERVICES="crapi-web api.mypremiumdealership.com"

# Images are pinned by digest in cases/crapi/compose.pinned.yml (the tag has no
# 1.1.6 images for most services); VERSION only fills the base file's tags.
export VERSION=main TLS_ENABLED=false LISTEN_IP=127.0.0.1

compose() {
  docker compose -p crapi -f "${CRAPI_DIR}/deploy/docker/docker-compose.yml" \
    -f "${REPO_ROOT}/cases/crapi/compose.pinned.yml" "$@"
}

wait_for_api() {
  # The login endpoint answers once identity, its database and the web gateway are up.
  for _ in $(seq 300); do
    code="$(curl -s -o /dev/null -w '%{http_code}' -X POST -H 'Content-Type: application/json' \
      -d '{"email":"x@example.com","password":"x"}' "${CRAPI_URL}/identity/api/auth/login" || true)"
    case "${code}" in 2??|4??) return 0 ;; esac
    sleep 2
  done
  echo "ERROR: crAPI did not answer at ${CRAPI_URL} within 10 minutes"
  compose ps
  exit 1
}

login() { # EMAIL PASSWORD -> prints the token
  curl -s -X POST -H 'Content-Type: application/json' \
    -d "{\"email\":\"$1\",\"password\":\"$2\"}" "${CRAPI_URL}/identity/api/auth/login" |
    python3 -c 'import json, sys; print(json.load(sys.stdin).get("token") or "")'
}

case "${1:-}" in
  setup)
    if [ ! -d "${CRAPI_DIR}/.git" ]; then
      git clone --branch "${CRAPI_TAG}" --depth 1 https://github.com/OWASP/crAPI.git "${CRAPI_DIR}"
    fi
    actual="$(git -C "${CRAPI_DIR}" rev-parse HEAD)"
    if [ "${actual}" != "${CRAPI_COMMIT}" ]; then
      echo "ERROR: ${CRAPI_DIR} is at ${actual}, expected ${CRAPI_COMMIT} (tag ${CRAPI_TAG})"
      exit 1
    fi
    compose pull ${SERVICES} postgresdb mongodb mailhog crapi-identity crapi-community crapi-workshop
    {
      echo "crapi_tag: ${CRAPI_TAG}"
      echo "crapi_commit: ${CRAPI_COMMIT}"
      echo "compose_env: TLS_ENABLED=${TLS_ENABLED}; images pinned by cases/crapi/compose.pinned.yml"
      echo "spec_sha256: $(sha256sum "${REPO_ROOT}/cases/crapi/crapi-openapi-spec.json" | cut -d' ' -f1)"
      compose config --images ${SERVICES} postgresdb mongodb mailhog crapi-identity crapi-community crapi-workshop | sort -u | while read -r img; do
        echo "image: ${img} $(docker image inspect --format '{{.Id}} {{index .RepoDigests 0}}' "${img}" 2>/dev/null || echo not-pulled)"
      done
    } > "${REPO_ROOT}/environment/crapi_images.txt"
    cat "${REPO_ROOT}/environment/crapi_images.txt"
    ;;
  up)
    compose up -d --wait ${SERVICES}
    wait_for_api
    echo "crAPI is up at ${CRAPI_URL}"
    ;;
  reset)
    compose down -v --remove-orphans > /dev/null 2>&1 || true
    compose up -d --wait ${SERVICES} > /dev/null 2>&1
    wait_for_api
    ;;
  check)
    fail=0
    for cred in "adam007@example.com adam007!123" "pogba006@example.com pogba006!123"; do
      set -- ${cred}
      token="$(login "$1" "$2")"
      if [ -z "${token}" ]; then
        echo "FAIL: login as $1 returned no token"; fail=1; continue
      fi
      dash="$(curl -s -o /dev/null -w '%{http_code}' -H "Authorization: Bearer ${token}" "${CRAPI_URL}/identity/api/v2/user/dashboard")"
      vehicles="$(curl -s -o /dev/null -w '%{http_code}' -H "Authorization: Bearer ${token}" "${CRAPI_URL}/identity/api/v2/vehicle/vehicles")"
      posts="$(curl -s -o /dev/null -w '%{http_code}' -H "Authorization: Bearer ${token}" "${CRAPI_URL}/community/api/v2/community/posts/recent")"
      shop="$(curl -s -o /dev/null -w '%{http_code}' -H "Authorization: Bearer ${token}" "${CRAPI_URL}/workshop/api/shop/products")"
      echo "$1: login ok, dashboard ${dash}, vehicles ${vehicles}, community posts ${posts}, shop products ${shop}"
    done
    anon="$(curl -s -o /dev/null -w '%{http_code}' "${CRAPI_URL}/identity/api/v2/user/dashboard")"
    bad="$(curl -s -o /dev/null -w '%{http_code}' -H 'Authorization: Bearer invalid' "${CRAPI_URL}/identity/api/v2/user/dashboard")"
    echo "dashboard without token: ${anon}; with an invalid token: ${bad}"
    docker stats --no-stream --format 'table {{.Name}}\t{{.MemUsage}}\t{{.CPUPerc}}' | grep -E 'NAME|crapi|postgres|mongo|mailhog|dealership' || true
    free -h | head -2
    exit "${fail}"
    ;;
  down)
    compose down -v --remove-orphans
    ;;
  *)
    echo "usage: $0 setup|up|reset|check|down"; exit 1 ;;
esac
