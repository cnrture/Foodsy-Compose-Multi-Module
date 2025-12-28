pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Hogwartia"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":app")
include(":navigation")
include(":core:ui")
include(":core:common")
include(":core:network")

// Features
include(":feature:splash")
include(":feature:onboarding")
include(":feature:login")
include(":feature:register")
include(":feature:home")
include(":feature:welcome")
include(":feature:characters")
include(":feature:characterdetail")
include(":feature:discount")
include(":feature:spelldetail")
include(":feature:favorites")
include(":feature:movies")
include(":feature:moviedetail")
include(":feature:spells")
include(":feature:profile")
include(":feature:search")
