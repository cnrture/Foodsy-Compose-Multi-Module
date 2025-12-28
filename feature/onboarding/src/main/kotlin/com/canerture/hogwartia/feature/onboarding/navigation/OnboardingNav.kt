package com.canerture.hogwartia.feature.onboarding.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.canerture.hogwartia.feature.onboarding.OnboardingScreen
import com.canerture.hogwartia.feature.onboarding.OnboardingViewModel
import com.canerture.hogwartia.ui.delegate.navigator.NavigationClientCollector

@Composable
fun OnboardingRoute() {
    val viewModel = hiltViewModel<OnboardingViewModel>()
    val uiEffect = viewModel.uiEffect
    NavigationClientCollector(viewModel.navigationClientEffect)
    OnboardingScreen(
        uiEffect = uiEffect,
        onAction = viewModel::onAction,
    )
}