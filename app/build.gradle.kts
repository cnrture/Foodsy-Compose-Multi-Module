plugins {
    alias(libs.plugins.foodsy.android.application)
    alias(libs.plugins.foodsy.android.application.compose)
    alias(libs.plugins.foodsy.android.firebase)
    alias(libs.plugins.foodsy.hilt)
    alias(libs.plugins.kotlinx.serialization.plugin)
}

android {
    namespace = "com.canerture.foodsy"

    defaultConfig {
        applicationId = "com.canerture.foodsy"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.navigation3.ui)

    implementation(projects.navigation)

    implementation(projects.core.ui)

    implementation(projects.feature.splash)
    implementation(projects.feature.onboarding)

    implementation(projects.feature.login)

    implementation(projects.feature.register)

    implementation(projects.feature.home)

    implementation(projects.feature.cart)

    implementation(projects.feature.categories)

    implementation(projects.feature.confirmorder)

    implementation(projects.feature.discount)

    implementation(projects.feature.dishdetail)

    implementation(projects.feature.favorites)

    implementation(projects.feature.forgotpassword)
}