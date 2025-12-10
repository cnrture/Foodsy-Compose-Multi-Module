package com.canerture.foodsy.feature.login

object LoginContract {
    data class UiState(
        val isLoading: Boolean = false,
    )

    sealed interface UiAction

    sealed interface UiEffect {
        data object NavigateToHome : UiEffect
    }
}