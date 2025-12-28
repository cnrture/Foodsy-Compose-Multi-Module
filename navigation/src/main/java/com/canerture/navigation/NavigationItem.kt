package com.canerture.navigation

import com.canerture.hogwartia.ui.navigation.Screen

sealed class NavigationItem(
    var route: Screen,
    var title: Int,
    val selectedIcon: Int,
    val unselectedIcon: Int,
) {
    companion object {
        fun getNavigationRoutes() = emptyList<String>()
        fun getNavigationItems() = emptyList<NavigationItem>()
    }
}