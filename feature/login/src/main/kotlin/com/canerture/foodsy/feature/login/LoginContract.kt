package com.canerture.foodsy.feature.login

object LoginContract {
    data class UiState(
        val isLoading: Boolean = false,
        val email: String = "",
        val password: String = "",
    )

    sealed interface UiAction {
        data class OnEmailChange(val email: String) : UiAction
        data class OnPasswordChange(val password: String) : UiAction
        data object OnLoginClick : UiAction
        data object OnGoogleLoginClick : UiAction
        data object OnRegisterClick : UiAction
    }

    sealed interface UiEffect
}