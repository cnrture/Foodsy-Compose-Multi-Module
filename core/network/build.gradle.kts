plugins {
    alias(libs.plugins.foodsy.android.library)
    alias(libs.plugins.foodsy.hilt)
    alias(libs.plugins.foodsy.android.firebase)
    alias(libs.plugins.foodsy.retrofit)
}

android {
    namespace = "com.canerture.core.network"

    defaultConfig {
        buildFeatures {
            buildConfig = true
        }

        buildConfigField(
            "String",
            "BASE_URL",
            "\"https://api.canerture.com/foodsy/\"",
        )
    }
}

dependencies {
    implementation(projects.core.common)
    //implementation(projects.core.datastore)
    //implementation(projects.core.datasource.logout)
}