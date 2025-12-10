package com.canerture.foodsy.feature.onboarding.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.canerture.foodsy.feature.onboarding.OnboardingScreen
import com.canerture.foodsy.feature.onboarding.OnboardingViewModel
import com.canerture.ui.navigation.Screen
import kotlinx.serialization.Serializable

@Serializable
data object OnboardingRoute : Screen

@Composable
fun OnboardingRoute() {
    val viewModel = hiltViewModel<OnboardingViewModel>()
    val uiEffect = viewModel.uiEffect
    OnboardingScreen(
        uiEffect = uiEffect,
        onAction = viewModel::onAction,
    )
}