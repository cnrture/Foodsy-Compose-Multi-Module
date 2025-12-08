package com.canerture.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.canerture.foodsy.feature.onboarding.navigation.onboardingRoute
import com.canerture.foodsy.feature.splash.navigation.Splash
import com.canerture.foodsy.feature.splash.navigation.splashRoute

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
        splashRoute()
        onboardingRoute()
        loginFlowNavigation(navController)
        mainFlowNavigation(navController)
    }
}