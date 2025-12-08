plugins {
    alias(libs.plugins.foodsy.android.library)
    alias(libs.plugins.foodsy.android.library.compose)
    alias(libs.plugins.kotlinx.serialization.plugin)
}

android {
    namespace = "com.canerture.foodsy.navigation"
}

dependencies {
    implementation(libs.navigation.compose)
    implementation(libs.kotlinx.serialization)

    implementation(projects.feature.splash)
    implementation(projects.feature.onboarding)

    implementation(projects.core.ui)
}