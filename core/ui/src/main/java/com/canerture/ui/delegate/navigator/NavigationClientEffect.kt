package com.canerture.ui.delegate.navigator

import com.canerture.ui.navigation.Screen

sealed interface NavigationClientEffect {
    data class NavigateTo(val route: Screen, val popup: Screen? = null) : NavigationClientEffect
    data object NavigateBack : NavigationClientEffect
}