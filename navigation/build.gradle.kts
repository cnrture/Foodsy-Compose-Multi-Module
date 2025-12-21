plugins {
    alias(libs.plugins.foodsy.android.library)
    alias(libs.plugins.foodsy.android.library.compose)
    alias(libs.plugins.kotlinx.serialization.plugin)
}

android {
    namespace = "com.canerture.foodsy.navigation"
}

dependencies {
    implementation(libs.navigation3.runtime)
    implementation(libs.navigation3.ui)
    implementation(libs.lifecycle.viewmodel.navigation3)
    implementation(libs.kotlinx.serialization)

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

    implementation(projects.core.ui)
}