plugins {
    alias(libs.plugins.foodsy.android.feature)
    alias(libs.plugins.foodsy.android.library.compose)
}

android {
    namespace = "com.canerture.foodsy.feature.splash"
    compileSdk = 36

    defaultConfig {
        minSdk = 21
        targetSdk = 36
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(projects.core.ui)
}