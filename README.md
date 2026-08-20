# KMP Mobile Sample

A Kotlin Multiplatform mobile application targeting Android and iOS, configured with end-to-end (E2E) testing powered by [Parikshan](https://github.com/aryapreetam/parikshan).

---

## Branch Selection by Mac Architecture

Select the appropriate branch based on your host development environment:

| Host Architecture | Recommended Branch | Compose Multiplatform | Kotlin |
| :--- | :--- | :--- | :--- |
| **Apple Silicon (M1 / M2 / M3 / M4, `arm64`)** | `main` | `1.11.0+` | `2.4.0` |
| **Intel Macs (`x86_64`)** | `check-cmp-1.10.1` | `1.10.1` | `2.3.21` |

---

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/aryapreetam/kmp-mobile.git
cd kmp-mobile
```

If you are running on an Intel Mac, switch to the `check-cmp-1.10.1` branch:
```bash
git checkout check-cmp-1.10.1
```

### 2. Run E2E Tests

Run automated tests across all configured mobile targets:

```bash
# Run all mobile E2E tests (Android + iOS)
./gradlew e2eTest

# Run tests targeting Android only (boots emulator automatically if connected)
./gradlew :shared:e2eAndroidTest

# Run tests targeting iOS only (boots iOS simulator automatically on macOS)
./gradlew :shared:e2eIosTest
```

---

## Project Structure

* [`androidApp/`](./androidApp) — Native Android application entry point.
* [`iosApp/`](./iosApp) — Native Xcode project and SwiftUI iOS entry point.
* [`shared/`](./shared) — Shared Compose Multiplatform UI and E2E test suites:
  * [`shared/src/commonMain`](./shared/src/commonMain/kotlin) — Shared application code and screens.
  * [`shared/src/commonTest`](./shared/src/commonTest/kotlin) — Intent-based cross-platform E2E tests (`e2eTest { ... }`).
