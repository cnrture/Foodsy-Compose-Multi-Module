package com.canerture.foodsy.navigation

import kotlinx.serialization.Serializable

sealed interface Screen {
    @Serializable
    data object Splash : Screen

    @Serializable
    data object Onboarding : Screen

    @Serializable
    data object Login : Screen

    @Serializable
    data object Register : Screen

    @Serializable
    data object ForgotPassword : Screen

    @Serializable
    data object Home : Screen

    @Serializable
    data object Categories : Screen

    @Serializable
    data object Favorites : Screen

    @Serializable
    data object Discount : Screen

    @Serializable
    data object Submenu : Screen

    @Serializable
    data object Orders : Screen

    @Serializable
    data object DishDetail : Screen

    @Serializable
    data object Cart : Screen

    @Serializable
    data object ConfirmOrder : Screen

    @Serializable
    data object OrderComplete : Screen

    @Serializable
    data object Profile : Screen

    @Serializable
    data object Search : Screen
}