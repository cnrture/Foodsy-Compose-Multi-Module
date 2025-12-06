package com.canerture.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.canerture.foodsy.feature.splash.navigation.Splash
import com.canerture.foodsy.feature.splash.navigation.splashScreen

@Composable
fun FSNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Splash,
        modifier = modifier,
    ) {
        splashScreen()
        loginFlowNavigation(navController)
        mainFlowNavigation(navController)
    }
}