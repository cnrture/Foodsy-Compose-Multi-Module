package com.canerture.foodsy.feature.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.canerture.foodsy.feature.login.LoginContract.UiAction
import com.canerture.foodsy.feature.login.LoginContract.UiEffect
import com.canerture.foodsy.feature.login.LoginContract.UiState
import com.canerture.ui.delegate.mvi.MVI
import com.canerture.ui.delegate.mvi.mvi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() :
    ViewModel(),
    MVI<UiState, UiAction, UiEffect> by mvi(UiState()) {

    override fun onAction(uiAction: UiAction) {
        viewModelScope.launch {
            when (uiAction) {
                is UiAction.OnEmailChange -> updateUiState { copy(email = uiAction.email) }
                is UiAction.OnPasswordChange -> updateUiState { copy(password = uiAction.password) }
                UiAction.OnLoginClick -> login()
                UiAction.OnGoogleLoginClick -> loginWithGoogle()
                UiAction.OnRegisterClick -> emitUiEffect(UiEffect.NavigateToRegister)
            }
        }
    }

    private fun login() {
        // Implement actual login logic here
    }

    private fun loginWithGoogle() {
        // Implement actual Google login logic here
    }
}