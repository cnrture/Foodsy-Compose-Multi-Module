package com.canerture.hogwartia.feature.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.canerture.hogwartia.feature.login.LoginContract.UiAction
import com.canerture.hogwartia.feature.login.LoginContract.UiEffect
import com.canerture.hogwartia.feature.login.LoginContract.UiState
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
class LoginViewModel @Inject constructor() :
    ViewModel(),
    MVI<UiState, UiAction, UiEffect> by mvi(UiState()),
    NavigationClient by navigationClient() {

    override fun onAction(uiAction: UiAction) {
        viewModelScope.launch {
            when (uiAction) {
                is UiAction.OnEmailChange -> updateUiState { copy(email = uiAction.email) }
                is UiAction.OnPasswordChange -> updateUiState { copy(password = uiAction.password) }
                UiAction.OnLoginClick -> login()
                UiAction.OnGoogleLoginClick -> loginWithGoogle()
                UiAction.OnRegisterClick -> navigateTo(Screen.Register)
            }
        }
    }

    private fun login() = viewModelScope.launch {
        delay(1000)
        navigateTo(Screen.BottomBar, Screen.Login)
    }

    private fun loginWithGoogle() = viewModelScope.launch {
        delay(1000)
        navigateTo(Screen.BottomBar, Screen.Login)
    }
}