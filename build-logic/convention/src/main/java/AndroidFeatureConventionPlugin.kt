package com.canerture.convention

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("foodsy.android.library")
                apply("foodsy.hilt")
                apply("foodsy.detekt")
                apply("org.jetbrains.kotlin.plugin.serialization")
            }

            dependencies {
                "implementation"(project(":core:ui"))
                "implementation"(project(":core:common"))

                "implementation"(libs.findLibrary("hilt.navigation.compose").get())
                "implementation"(libs.findLibrary("lifecycle.runtime.compose").get())
                "implementation"(libs.findLibrary("lifecycle.viewmodel.compose").get())
                "implementation"(libs.findLibrary("navigation.compose").get())
                "implementation"(libs.findLibrary("kotlinx.serialization").get())
            }
        }
    }
}
