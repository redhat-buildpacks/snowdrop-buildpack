#!/usr/bin/env bash
set -e

ID_PREFIX="dev.snowdrop.buildpacks"

DEFAULT_PREFIX=redhat/buildpacks-stack-snowdrop

REPO_PREFIX=${DEFAULT_PREFIX}

usage() {
  echo "Usage: "
  echo "  $0 [-p <prefix>] <dir>"
  echo "    -p    prefix to use for images      (default: ${DEFAULT_PREFIX})"
  echo "   <dir>  directory of stack to build"
  exit 1; 
}

while getopts "v:p:" o; do
  case "${o}" in
    p)
      REPO_PREFIX=${OPTARG}
      ;;
    \?)
      echo "Invalid option: -$OPTARG" 1>&2
      usage
      ;;
    :)
      usage
      ;;
  esac
done

STACK_DIR=${@:$OPTIND:1}

if [[ -z ${REPO_PREFIX} ]]; then
  echo "Prefix cannot be empty"
  echo
  usage
  exit 1
fi

if [[ -z ${STACK_DIR} ]]; then
  echo "Must specify stack directory"
  echo
  usage
  exit 1
fi

realpath() {
  OURPWD=$PWD
  cd "$(dirname "$1")"
  LINK=$(readlink "$(basename "$1")")
  while [ "$LINK" ]; do
    cd "$(dirname "$LINK")"
    LINK=$(readlink "$(basename "$1")")
  done
  REALPATH="$PWD/$(basename "$1")"
  cd "$OURPWD"
  echo "$REALPATH"
}

DIR=$(cd $(dirname $0) && pwd)
IMAGE_DIR=$(realpath "${STACK_DIR}")
TAG=$(basename "${IMAGE_DIR}")
STACK_ID="${ID_PREFIX}.stack.$(basename "${IMAGE_DIR}")"
BASE_IMAGE=${REPO_PREFIX}-base:${TAG}
RUN_IMAGE=${REPO_PREFIX}-run:${TAG}
BUILD_IMAGE=${REPO_PREFIX}-build:${TAG}

# if [[ -d "${IMAGE_DIR}/base" ]]; then
#   echo "BUILDING ${BASE_IMAGE}..."
#   docker build -t "${BASE_IMAGE}" "${IMAGE_DIR}/base"
# fi

BASE_IMAGE=registry.access.redhat.com/ubi8/openjdk-17
echo "BUILDING ${BUILD_IMAGE}  using as BASE IMAGE: ${BASE_IMAGE} ..."
docker build --build-arg "base_image=${BASE_IMAGE}" --build-arg "stack_id=${STACK_ID}" -t "${BUILD_IMAGE}"  "${IMAGE_DIR}/build"

BASE_IMAGE=registry.access.redhat.com/ubi8/openjdk-17-runtime
echo "BUILDING ${RUN_IMAGE} using as BASE IMAGE: ${BASE_IMAGE} ..."
docker build --build-arg "base_image=${BASE_IMAGE}" --build-arg "stack_id=${STACK_ID}" -t "${RUN_IMAGE}" "${IMAGE_DIR}/run"

echo
echo "STACK BUILT!"
echo
echo "Stack ID: ${STACK_ID}"
echo "Images:"
for IMAGE in "${BUILD_IMAGE}" "${RUN_IMAGE}"; do
  echo "    ${IMAGE}"
done