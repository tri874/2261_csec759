#!/bin/bash
# a3_build_fork.sh
#
# Builds the Assignment 3 prototype: EvoMaster v6.2.0 with
# patches/evomaster-v6.2.0-a3.patch applied, packaged as a Docker image the
# run scripts can use through EVOMASTER_IMAGE.
#
# Only Docker and git are needed on the host: Maven and the JDK run inside the
# official maven image (pinned below).
#
# Steps (STEPS, default "clone build image"):
#   clone   clone WebFuzzing/EvoMaster at tag v6.2.0 into BUILD_DIR, check the
#           commit, apply the patch
#   build   mvn package of the core module (tests skipped) -> core/target/evomaster.jar
#   image   docker build with EvoMaster's own Dockerfile -> ${IMAGE}
#   tests   optional: EvoMaster's Not-Recognized end-to-end tests (upstream test
#           and our SecurityNotRecognizedConfirmationEMTest) plus the two unit
#           tests touched by the patch. Slow (builds the e2e module).
#
# Environment variables:
#   BUILD_DIR   where to clone (default: ../evomaster-a3, next to this folder)
#   IMAGE       image name (default: evomaster-a3:<first 12 chars of the patch sha256>)
#   EXTRA_PATCHES  further patch files applied after the main one, e.g.
#               patches/evomaster-a3-diagnostics.patch (logging only, used for
#               the H2 investigation, notes/a3_decisions.md D3)
#   BUILD_RECORD   build record file (default: environment/a3_build.txt)
#   TESTS_OUT      output folder of the tests step (default: raw/a3/build; final: raw/final/build)
#
# Writes environment/a3_build.txt (versions, commit, patch hash, image id) and,
# for the tests step, raw/a3/build/e2e_tests.log.
#
# Example:
#   scripts/a3_build_fork.sh 2>&1 | tee logs/a3_build.log

set -euo pipefail

REPO_ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
cd "${REPO_ROOT}"

UPSTREAM_URL="https://github.com/WebFuzzing/EvoMaster.git"
UPSTREAM_TAG="v6.2.0"
UPSTREAM_COMMIT="efad6f2bd7ff0025852a6203d307303c568e763a"
PATCH="${REPO_ROOT}/patches/evomaster-v6.2.0-a3.patch"
MAVEN_IMAGE="maven:3.9.9-eclipse-temurin-17"

PATCH_SHA="$(sha256sum "${PATCH}" | cut -d' ' -f1)"
BUILD_DIR="${BUILD_DIR:-${REPO_ROOT}/../evomaster-a3}"
IMAGE="${IMAGE:-evomaster-a3:${PATCH_SHA:0:12}}"
STEPS="${STEPS:-clone build image}"
EXTRA_PATCHES="${EXTRA_PATCHES:-}"
BUILD_RECORD="${BUILD_RECORD:-environment/a3_build.txt}"
TESTS_OUT="${TESTS_OUT:-raw/a3/build}"

log() { echo; echo "##### $(date -u +%H:%M:%S) $*"; }

mvn_in_docker() { # args...: run Maven in the pinned image, with a cache volume for ~/.m2
  docker run --rm \
    -v "${BUILD_DIR}:/src" -w /src \
    -v evomaster-a3-m2:/root/.m2 \
    "${MAVEN_IMAGE}" mvn -B "$@"
}

for step in ${STEPS}; do
  case "${step}" in
    clone)
      log "cloning ${UPSTREAM_URL} ${UPSTREAM_TAG} into ${BUILD_DIR}"
      if [ -e "${BUILD_DIR}" ]; then
        echo "ERROR: ${BUILD_DIR} exists. Remove it or set BUILD_DIR."
        exit 1
      fi
      git clone -q --depth 1 --branch "${UPSTREAM_TAG}" "${UPSTREAM_URL}" "${BUILD_DIR}"
      actual="$(git -C "${BUILD_DIR}" rev-parse HEAD)"
      if [ "${actual}" != "${UPSTREAM_COMMIT}" ]; then
        echo "ERROR: tag ${UPSTREAM_TAG} is at ${actual}, expected ${UPSTREAM_COMMIT}"
        exit 1
      fi
      git -C "${BUILD_DIR}" apply "${PATCH}"
      for extra in ${EXTRA_PATCHES}; do
        echo "applying extra patch ${extra}"
        git -C "${BUILD_DIR}" apply "${REPO_ROOT}/${extra}"
      done
      git -C "${BUILD_DIR}" status --short
      ;;
    build)
      log "building core/target/evomaster.jar with ${MAVEN_IMAGE} (tests skipped)"
      mvn_in_docker -q -DskipTests -pl core -am package
      ls -l "${BUILD_DIR}/core/target/evomaster.jar"
      ;;
    image)
      log "building Docker image ${IMAGE}"
      docker build -q -t "${IMAGE}" "${BUILD_DIR}"
      mkdir -p environment
      {
        echo "date_utc: $(date -u +%Y-%m-%dT%H:%M:%SZ)"
        echo "upstream: ${UPSTREAM_URL} tag ${UPSTREAM_TAG} commit ${UPSTREAM_COMMIT}"
        echo "patch: patches/evomaster-v6.2.0-a3.patch sha256 ${PATCH_SHA}"
        for extra in ${EXTRA_PATCHES}; do echo "extra_patch: ${extra} sha256 $(sha256sum "${REPO_ROOT}/${extra}" | cut -d' ' -f1)"; done
        echo "maven_image: ${MAVEN_IMAGE} ($(docker image inspect --format '{{index .RepoDigests 0}}' "${MAVEN_IMAGE}" 2>/dev/null || echo unknown))"
        echo "jar_sha256: $(sha256sum "${BUILD_DIR}/core/target/evomaster.jar" | cut -d' ' -f1)"
        echo "image: ${IMAGE}"
        echo "image_id: $(docker image inspect --format '{{.Id}}' "${IMAGE}")"
        echo "base_image: $(head -1 "${BUILD_DIR}/Dockerfile")"
        echo "docker_version: $(docker version --format '{{.Server.Version}}' 2>/dev/null || echo unknown)"
        echo "host: $(uname -srm)"
      } > "${BUILD_RECORD}"
      cat "${BUILD_RECORD}"
      log "smoke check: the image knows the new options"
      docker run --rm "${IMAGE}" --help 2>&1 | grep -E "notRecognized(CredentialEvidence|UserAttribution)" \
        || echo "WARNING: the new options were not found in '${IMAGE} --help' output; check the build"
      ;;
    tests)
      log "EvoMaster tests touched by the patch (slow)"
      mkdir -p "${TESTS_OUT}"
      set +e
      mvn_in_docker -pl core -am \
        -Dtest='ConfigToMarkdownTest,ExperimentalFaultCategoryTest' \
        -Dsurefire.failIfNoSpecifiedTests=false test 2>&1 | tee "${TESTS_OUT}/unit_tests.log" | tail -30
      unit="${PIPESTATUS[0]}"
      mvn_in_docker -pl core-tests/e2e-tests/spring/spring-rest-openapi-v3 -am \
        -Dtest='SecurityNotRecognizedEMTest,SecurityNotRecognizedConfirmationEMTest' \
        -Dsurefire.failIfNoSpecifiedTests=false test 2>&1 | tee "${TESTS_OUT}/e2e_tests.log" | tail -30
      e2e="${PIPESTATUS[0]}"
      set -e
      echo "unit tests exit status: ${unit}; e2e tests exit status: ${e2e}" | tee "${TESTS_OUT}/tests_status.txt"
      ;;
    *) echo "ERROR: unknown step ${step}"; exit 1 ;;
  esac
done

log "done: ${STEPS} (image ${IMAGE})"
