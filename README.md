# KMP Mobile Sample

A Kotlin Multiplatform mobile application targeting Android and iOS, configured with end-to-end (E2E) testing powered by [Parikshan](https://github.com/aryapreetam/parikshan).

---

## Unified Multi-Version Support

This project uses **dynamic version catalogs** on the `main` branch to support multiple Compose Multiplatform (CMP) and Kotlin versions seamlessly without needing separate git branches:

| Profile | Compose Multiplatform | Kotlin | Lifecycle | Target Support |
| :--- | :--- | :--- | :--- | :--- |
| **`1.10` (Default)** | `1.10.1` | `2.3.21` | `2.9.6` | Android & iOS (Intel `x86_64` + Apple Silicon `arm64`) |
| **`1.11`** | `1.11.1` | `2.4.10` | `2.11.0-beta01` | Android (Local) & iOS (Apple Silicon CI) |
| **`1.12`** | `1.12.0` | `2.4.0` | `2.11.0` | Android (Local) & iOS (Apple Silicon CI) |

---

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/aryapreetam/kmp-mobile.git
cd kmp-mobile
```

### 2. Run E2E Tests

Run automated tests across all configured mobile targets:

```bash
# Run baseline E2E tests (defaults to CMP 1.10.1, runs Android + iOS locally)
./gradlew e2eTest

# Run on specific CMP profiles
./gradlew e2eTest -PcmpProfile=1.10
./gradlew e2eTest --targets=android -PcmpProfile=1.11
./gradlew e2eTest --targets=android -PcmpProfile=1.12

# Run targeting Android only
./gradlew :shared:e2eAndroidTest

# Run targeting iOS only (on macOS)
./gradlew :shared:e2eIosTest
```

### 3. Verify Entire CMP Matrix Locally

You can execute the automated all-in-one verification script to test across all CMP profiles:

```bash
./scripts/verify-all-cmp.sh
```

---

## Project Structure

* [`androidApp/`](./androidApp) — Native Android application entry point.
* [`iosApp/`](./iosApp) — Native Xcode project and SwiftUI iOS entry point.
* [`scripts/`](./scripts) — Matrix verification scripts (`verify-all-cmp.sh`).
* [`shared/`](./shared) — Shared Compose Multiplatform UI and E2E test suites:
  * [`shared/src/commonMain`](./shared/src/commonMain/kotlin) — Shared application code and screens.
  * [`shared/src/commonTest`](./shared/src/commonTest/kotlin) — Intent-based cross-platform E2E tests (`e2eTest { ... }`).
