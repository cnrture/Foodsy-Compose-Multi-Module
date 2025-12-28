plugins {
    alias(libs.plugins.hogwartia.jvm.library)
    id("org.jetbrains.kotlin.plugin.compose")
}

group = "com.canerture.hogwartia.common"

dependencies {
    implementation(platform(libs.compose.bom))
    implementation(libs.material3)
    implementation(libs.lifecycle.runtime.compose)
}