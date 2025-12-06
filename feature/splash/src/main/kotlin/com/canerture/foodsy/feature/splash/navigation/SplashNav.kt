package com.canerture.foodsy.feature.splash.navigation

import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.canerture.foodsy.feature.splash.SplashScreen
import com.canerture.foodsy.feature.splash.SplashViewModel
import com.canerture.ui.navigation.Screen
import kotlinx.serialization.Serializable

@Serializable
data object Splash : Screen

fun NavGraphBuilder.splashScreen() {
    composable<Splash> {
        val viewModel = hiltViewModel<SplashViewModel>()
        val uiState = viewModel.uiState.collectAsStateWithLifecycle()
        val uiEffect = viewModel.uiEffect
        SplashScreen(
            uiState = uiState.value,
            uiEffect = uiEffect,
            onAction = viewModel::onAction,
        )
    }
}