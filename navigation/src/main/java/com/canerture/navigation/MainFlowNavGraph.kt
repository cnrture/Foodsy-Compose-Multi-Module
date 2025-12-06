package com.canerture.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.canerture.ui.navigation.Screen
import kotlinx.serialization.Serializable

@Serializable
object MainFlow : Screen

internal fun NavGraphBuilder.mainFlowNavigation(navController: NavHostController) {
}