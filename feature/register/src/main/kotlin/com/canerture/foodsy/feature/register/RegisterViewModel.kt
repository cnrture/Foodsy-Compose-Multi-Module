package com.canerture.foodsy.feature.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.canerture.foodsy.feature.register.RegisterContract.UiAction
import com.canerture.foodsy.feature.register.RegisterContract.UiEffect
import com.canerture.foodsy.feature.register.RegisterContract.UiState
import com.canerture.ui.delegate.mvi.MVI
import com.canerture.ui.delegate.mvi.mvi
import com.canerture.ui.delegate.navigator.NavigationClient
import com.canerture.ui.delegate.navigator.navigationClient
import com.canerture.ui.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor() :
    ViewModel(),
    MVI<UiState, UiAction, UiEffect> by mvi(UiState()),
    NavigationClient by navigationClient() {

    override fun onAction(uiAction: UiAction) {
        viewModelScope.launch {
            when (uiAction) {
                is UiAction.OnUsernameChange -> updateUiState { copy(username = uiAction.username) }
                is UiAction.OnEmailChange -> updateUiState { copy(email = uiAction.email) }
                is UiAction.OnPasswordChange -> updateUiState { copy(password = uiAction.password) }
                UiAction.OnRegisterClick -> register()
                UiAction.OnGoogleRegisterClick -> registerWithGoogle()
                UiAction.OnLoginClick -> navigateTo(Screen.Login, Screen.Register)
            }
        }
    }

    private fun register() = viewModelScope.launch {
        delay(1000)
        navigateTo(Screen.Login, Screen.Register)
    }

    private fun registerWithGoogle() = viewModelScope.launch {
        delay(1000)
        navigateTo(Screen.Home, Screen.Register)
    }
}