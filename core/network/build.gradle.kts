plugins {
    alias(libs.plugins.hogwartia.android.library)
    alias(libs.plugins.hogwartia.hilt)
    alias(libs.plugins.hogwartia.android.firebase)
    alias(libs.plugins.hogwartia.retrofit)
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
            "\"https://api.canerture.com/hogwartia/\"",
        )
    }
}

dependencies {
    implementation(projects.core.common)
    //implementation(projects.core.datastore)
    //implementation(projects.core.datasource.logout)
}