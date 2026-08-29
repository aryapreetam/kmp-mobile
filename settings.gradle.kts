rootProject.name = "kmp-mobile"

pluginManagement {
    // includeBuild("/Users/preetam/workspace/parikshan/gradle-plugins")
    repositories {
        mavenLocal()
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

val profile = providers.gradleProperty("cmpProfile").orNull ?: "1.10"

dependencyResolutionManagement {
    repositories {
        mavenLocal()
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
    versionCatalogs {
        create("libs") {
            when (profile) {
                "1.10" -> {
                    version("kotlin", "2.3.21")
                    version("composeMultiplatform", "1.10.1")
                    version("androidx-lifecycle", "2.9.6")
                    version("androidx-activity", "1.10.1")
                }
                "1.11" -> {
                    version("kotlin", "2.4.10")
                    version("composeMultiplatform", "1.11.1")
                    version("androidx-lifecycle", "2.11.0-beta01")
                    version("androidx-activity", "1.13.0")
                }
                "1.12" -> {
                    version("kotlin", "2.4.0")
                    version("composeMultiplatform", "1.12.0")
                    version("androidx-lifecycle", "2.11.0")
                    version("androidx-activity", "1.13.0")
                }
            }
        }
    }
}

// includeBuild("/Users/preetam/workspace/parikshan")

include(":androidApp")
include(":shared")