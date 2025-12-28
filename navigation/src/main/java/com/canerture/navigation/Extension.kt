package com.canerture.navigation

import com.canerture.hogwartia.ui.navigation.Screen

fun Screen.getRoute(): String {
    return this::class.java.canonicalName.orEmpty()
}