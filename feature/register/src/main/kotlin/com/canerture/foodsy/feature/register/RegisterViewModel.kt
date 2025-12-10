package com.canerture.foodsy.feature.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.canerture.foodsy.feature.register.RegisterContract.UiAction
import com.canerture.foodsy.feature.register.RegisterContract.UiEffect
import com.canerture.foodsy.feature.register.RegisterContract.UiState
import com.canerture.ui.delegate.mvi.MVI
import com.canerture.ui.delegate.mvi.mvi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor() :
    ViewModel(),
    MVI<UiState, UiAction, UiEffect> by mvi(UiState()) {

    override fun onAction(uiAction: UiAction) {
        viewModelScope.launch {
            when (uiAction) {
                is UiAction.OnUsernameChange -> updateUiState { copy(username = uiAction.username) }
                is UiAction.OnEmailChange -> updateUiState { copy(email = uiAction.email) }
                is UiAction.OnPasswordChange -> updateUiState { copy(password = uiAction.password) }
                UiAction.OnRegisterClick -> register()
                UiAction.OnGoogleRegisterClick -> registerWithGoogle()
                UiAction.OnLoginClick -> emitUiEffect(UiEffect.NavigateLogin)
            }
        }
    }

    private fun register() {
        // Registration logic to be implemented
    }

    private fun registerWithGoogle() {
        // Google registration logic to be implemented
    }
}