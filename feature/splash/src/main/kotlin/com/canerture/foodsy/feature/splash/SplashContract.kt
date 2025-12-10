package com.canerture.foodsy.feature.splash

object SplashContract {
    sealed interface UiEffect {
        data object NavigateToOnboarding : UiEffect
        data object NavigateToLogin : UiEffect
    }
}