package com.canerture.hogwartia.feature.register

object RegisterContract {
    data class UiState(
        val isLoading: Boolean = false,
        val username: String = "",
        val email: String = "",
        val password: String = "",
    )

    sealed interface UiAction {
        data class OnUsernameChange(val username: String) : UiAction
        data class OnEmailChange(val email: String) : UiAction
        data class OnPasswordChange(val password: String) : UiAction
        data object OnRegisterClick : UiAction
        data object OnGoogleRegisterClick : UiAction
        data object OnLoginClick : UiAction
    }

    sealed interface UiEffect
}