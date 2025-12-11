package com.canerture.foodsy.feature.onboarding

object OnboardingContract {
    sealed interface UiAction {
        data object OnSkipClick : UiAction
    }

    sealed interface UiEffect
}