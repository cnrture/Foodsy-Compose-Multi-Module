plugins {
    alias(libs.plugins.hogwartia.android.library)
    alias(libs.plugins.hogwartia.android.library.compose)
    alias(libs.plugins.kotlinx.serialization.plugin)
}

android {
    namespace = "com.canerture.core.ui"
}

dependencies {
    implementation(libs.navigation3.runtime)
    implementation(libs.kotlinx.serialization)
}