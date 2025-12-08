package com.canerture.foodsy.feature.onboarding.navigation

import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.canerture.foodsy.feature.onboarding.OnboardingScreen
import com.canerture.foodsy.feature.onboarding.OnboardingViewModel
import com.canerture.ui.navigation.Screen
import kotlinx.serialization.Serializable

@Serializable
data object Onboarding : Screen

fun NavGraphBuilder.onboardingRoute() {
    composable<Onboarding> {
        val viewModel = hiltViewModel<OnboardingViewModel>()
        val uiEffect = viewModel.uiEffect
        OnboardingScreen(
            uiEffect = uiEffect,
            onAction = viewModel::onAction,
        )
    }
}