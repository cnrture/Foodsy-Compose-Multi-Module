package com.canerture.ui.navigation

import androidx.navigation3.runtime.NavKey
import com.canerture.core.ui.R
import kotlinx.serialization.Serializable

@Serializable
sealed interface Screen : NavKey {
    @Serializable
    data object Splash : Screen

    @Serializable
    data object Onboarding : Screen

    @Serializable
    data object Login : Screen

    @Serializable
    data object Register : Screen

    @Serializable
    data object BottomBar : Screen

    @Serializable
    data object Cart : Screen

    @Serializable
    data object Categories : Screen
}

@Serializable
sealed class BottomBarScreen(
    val icon: Int,
    val iconSelected: Int,
) : NavKey {
    @Serializable
    data object Home : BottomBarScreen(
        icon = R.drawable.ic_home_outline,
        iconSelected = R.drawable.ic_home_filled,
    )

    @Serializable
    data object Favorites : BottomBarScreen(
        icon = R.drawable.ic_fav_outline,
        iconSelected = R.drawable.ic_fav_filled,
    )

    @Serializable
    data object Categories : BottomBarScreen(
        icon = R.drawable.ic_categories_outline,
        iconSelected = R.drawable.ic_categories_filled,
    )

    @Serializable
    data object Discounts : BottomBarScreen(
        icon = R.drawable.ic_discount_outline,
        iconSelected = R.drawable.ic_discount_filled,
    )

    @Serializable
    data object Cart : BottomBarScreen(
        icon = R.drawable.ic_cart_outline,
        iconSelected = R.drawable.ic_cart_filled,
    )
}