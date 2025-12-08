plugins {
    alias(libs.plugins.foodsy.android.feature)
    alias(libs.plugins.foodsy.android.library.compose)
}

android {
    namespace = "com.canerture.foodsy.feature.splash"
}

dependencies {
    implementation(projects.core.ui)
}