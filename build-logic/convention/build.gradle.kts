import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions.jvmTarget.set(JvmTarget.JVM_17)
}

dependencies {
    compileOnly(libs.android.plugin)
    compileOnly(libs.compose.plugin)
    compileOnly(libs.kotlin.plugin)
    compileOnly(libs.ksp.plugin)
    compileOnly(libs.detekt.plugin)
}

gradlePlugin {
    plugins {
        register("androidApplicationCompose") {
            id = libs.plugins.hogwartia.android.application.compose.get().pluginId
            implementationClass = "com.canerture.convention.AndroidApplicationComposeConventionPlugin"
        }
        register("androidApplication") {
            id = libs.plugins.hogwartia.android.application.asProvider().get().pluginId
            implementationClass = "com.canerture.convention.AndroidApplicationConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = libs.plugins.hogwartia.android.library.compose.get().pluginId
            implementationClass = "com.canerture.convention.AndroidLibraryComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = libs.plugins.hogwartia.android.library.asProvider().get().pluginId
            implementationClass = "com.canerture.convention.AndroidLibraryConventionPlugin"
        }
        register("androidFeature") {
            id = libs.plugins.hogwartia.android.feature.get().pluginId
            implementationClass = "com.canerture.convention.AndroidFeatureConventionPlugin"
        }
        register("hilt") {
            id = libs.plugins.hogwartia.hilt.get().pluginId
            implementationClass = "com.canerture.convention.HiltConventionPlugin"
        }
        register("androidFirebase") {
            id = libs.plugins.hogwartia.android.firebase.get().pluginId
            implementationClass = "com.canerture.convention.AndroidApplicationFirebaseConventionPlugin"
        }
        register("jvmLibrary") {
            id = libs.plugins.hogwartia.jvm.library.get().pluginId
            implementationClass = "com.canerture.convention.JvmLibraryConventionPlugin"
        }
        register("detekt") {
            id = libs.plugins.hogwartia.detekt.get().pluginId
            implementationClass = "com.canerture.convention.DetektConventionPlugin"
        }
        register("retrofit") {
            id = libs.plugins.hogwartia.retrofit.get().pluginId
            implementationClass = "com.canerture.convention.RetrofitConventionPlugin"
        }
    }
}