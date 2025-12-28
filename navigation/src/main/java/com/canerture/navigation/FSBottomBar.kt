package com.canerture.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.canerture.hogwartia.ui.navigation.BottomBarScreen
import com.canerture.hogwartia.ui.theme.HWTheme
import com.canerture.home.feature.home.navigation.HomeRoute

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HWBottomBar() {
    val bottomBarItems = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Favorites,
        BottomBarScreen.Categories,
        BottomBarScreen.Discounts,
        BottomBarScreen.Cart,
    )

    val backStack = rememberNavBackStack(BottomBarScreen.Home)

    var currentBottomBarScreen: BottomBarScreen by rememberSaveable(stateSaver = BottomBarScreenSaver) {
        mutableStateOf(BottomBarScreen.Home)
    }

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = HWTheme.colors.lightYellow,
            ) {
                bottomBarItems.forEach { destination ->
                    val isSelected = currentBottomBarScreen == destination
                    val icon = if (isSelected) destination.iconSelected else destination.icon
                    NavigationBarItem(
                        selected = isSelected,
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = HWTheme.colors.brown,
                            unselectedIconColor = HWTheme.colors.brown,
                            indicatorColor = HWTheme.colors.lightYellow,
                        ),
                        icon = {
                            Icon(
                                painter = painterResource(icon),
                                contentDescription = "$destination icon",
                            )
                        },
                        onClick = {
                            if (backStack.lastOrNull() != destination) {
                                if (backStack.lastOrNull() in bottomBarItems) {
                                    backStack.removeAt(backStack.lastIndex)
                                }
                                backStack.add(destination)
                                currentBottomBarScreen = destination
                            }
                        }
                    )
                }
            }
        }
    ) {
        NavDisplay(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            backStack = backStack,
            onBack = { backStack.removeLastOrNull() },
            entryDecorators = listOf(
                rememberSaveableStateHolderNavEntryDecorator(),
                rememberViewModelStoreNavEntryDecorator(),
            ),
            entryProvider = entryProvider {
                entry<BottomBarScreen.Home> { HomeRoute() }
                entry<BottomBarScreen.Favorites> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Favorites")
                    }
                }
                entry<BottomBarScreen.Categories> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Characters")
                    }
                }
                entry<BottomBarScreen.Discounts> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Discounts")
                    }
                }
                entry<BottomBarScreen.Cart> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Welcome")
                    }
                }
            }
        )
    }
}

val BottomBarScreenSaver = Saver<BottomBarScreen, String>(
    save = { it::class.simpleName ?: "Unknown" },
    restore = {
        when (it) {
            BottomBarScreen.Home::class.simpleName -> BottomBarScreen.Home
            BottomBarScreen.Favorites::class.simpleName -> BottomBarScreen.Favorites
            BottomBarScreen.Categories::class.simpleName -> BottomBarScreen.Categories
            BottomBarScreen.Discounts::class.simpleName -> BottomBarScreen.Discounts
            else -> BottomBarScreen.Cart
        }
    },
)