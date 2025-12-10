package com.canerture.foodsy.feature.splash.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.canerture.foodsy.feature.splash.SplashScreen
import com.canerture.foodsy.feature.splash.SplashViewModel
import com.canerture.ui.navigation.Screen
import kotlinx.serialization.Serializable

@Serializable
data object SplashRoute : Screen

@Composable
fun SplashRoute(
    onNavigateOnboarding: () -> Unit,
    onNavigateLogin: () -> Unit,
) {
    val viewModel = hiltViewModel<SplashViewModel>()
    val uiEffect = viewModel.uiEffect
    SplashScreen(
        uiEffect = uiEffect,
        onNavigateOnboarding = onNavigateOnboarding,
        onNavigateLogin = onNavigateLogin,
    )
}