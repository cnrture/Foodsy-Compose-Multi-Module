plugins {
    alias(libs.plugins.foodsy.android.library)
    alias(libs.plugins.foodsy.android.library.compose)
    alias(libs.plugins.kotlinx.serialization.plugin)
}

android {
    namespace = "com.canerture.core.ui"
}

dependencies {
    implementation(libs.navigation3.runtime)
    implementation(libs.kotlinx.serialization)
}