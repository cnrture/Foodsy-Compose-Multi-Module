plugins {
    alias(libs.plugins.foodsy.android.feature)
    alias(libs.plugins.foodsy.android.library.compose)
}

android {
    namespace = "com.canerture.foodsy.feature.login"
}

dependencies {
    implementation(projects.core.ui)
}