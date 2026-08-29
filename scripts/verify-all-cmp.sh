#!/usr/bin/env bash
set -e

# Resolve kmp-mobile project root directory
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(cd "${SCRIPT_DIR}/.." && pwd)"
cd "${PROJECT_ROOT}"

ARCH=$(uname -m)
EXTRA_ARGS=("$@")

echo "================================================================="
echo " ==> [1/3] Testing kmp-mobile on CMP 1.10.1 (Profile: 1.10)..."
echo "================================================================="
./gradlew e2eTest -PcmpProfile=1.10 "${EXTRA_ARGS[@]}"

echo "================================================================="
echo " ==> [2/3] Testing kmp-mobile on CMP 1.11.1 (Profile: 1.11)..."
echo "================================================================="
if [ "$ARCH" = "x86_64" ]; then
  # On Intel Mac, run Android E2E (CMP 1.11+ dropped iosX64 simulator support)
  ./gradlew e2eTest --targets=android -PcmpProfile=1.11 "${EXTRA_ARGS[@]}"
else
  ./gradlew e2eTest -PcmpProfile=1.11 "${EXTRA_ARGS[@]}"
fi

echo "================================================================="
echo " ==> [3/3] Testing kmp-mobile on CMP 1.12.0 (Profile: 1.12)..."
echo "================================================================="
if [ "$ARCH" = "x86_64" ]; then
  ./gradlew e2eTest --targets=android -PcmpProfile=1.12 "${EXTRA_ARGS[@]}"
else
  ./gradlew e2eTest -PcmpProfile=1.12 "${EXTRA_ARGS[@]}"
fi

# Cleanup Gradle daemons
./gradlew --stop >/dev/null 2>&1 || true

echo "================================================================="
echo " ✅ SUCCESS: All CMP versions (1.10.1, 1.11.1, 1.12.0) passed!"
echo "================================================================="
