package com.canerture.foodsy.feature.onboarding.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.canerture.foodsy.feature.onboarding.OnboardingScreen
import com.canerture.foodsy.feature.onboarding.OnboardingViewModel

@Composable
fun OnboardingRoute(
    onNavigateLogin: () -> Unit,
) {
    val viewModel = hiltViewModel<OnboardingViewModel>()
    val uiEffect = viewModel.uiEffect
    OnboardingScreen(
        uiEffect = uiEffect,
        onAction = viewModel::onAction,
        onNavigateLogin = onNavigateLogin,
    )
}