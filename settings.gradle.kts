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

rootProject.name = "Foodsy"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":app")
include(":navigation")
include(":core:ui")
include(":core:common")

// Features
include(":feature:splash")
include(":feature:onboarding")
include(":feature:login")
include(":feature:register")
include(":feature:home")
include(":feature:cart")
include(":feature:categories")
include(":feature:confirmorder")
include(":feature:discount")
include(":feature:dishdetail")
include(":feature:favorites")
