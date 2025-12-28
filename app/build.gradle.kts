plugins {
    alias(libs.plugins.hogwartia.android.application)
    alias(libs.plugins.hogwartia.android.application.compose)
    alias(libs.plugins.hogwartia.android.firebase)
    alias(libs.plugins.hogwartia.hilt)
    alias(libs.plugins.kotlinx.serialization.plugin)
}

android {
    namespace = "com.canerture.hogwartia"

    defaultConfig {
        applicationId = "com.canerture.hogwartia"
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

    implementation(projects.feature.ordercomplete)

    implementation(projects.feature.orders)

    implementation(projects.feature.profile)

    implementation(projects.feature.search)
}