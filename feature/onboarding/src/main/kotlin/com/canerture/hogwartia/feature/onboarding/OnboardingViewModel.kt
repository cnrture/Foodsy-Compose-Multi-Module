package com.canerture.hogwartia.feature.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.canerture.hogwartia.feature.onboarding.OnboardingContract.UiAction
import com.canerture.hogwartia.feature.onboarding.OnboardingContract.UiEffect
import com.canerture.hogwartia.ui.delegate.mvi.MVI
import com.canerture.hogwartia.ui.delegate.mvi.mvi
import com.canerture.hogwartia.ui.delegate.navigator.NavigationClient
import com.canerture.hogwartia.ui.delegate.navigator.navigationClient
import com.canerture.hogwartia.ui.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor() :
    ViewModel(),
    MVI<Unit, UiAction, UiEffect> by mvi(Unit),
    NavigationClient by navigationClient() {

    override fun onAction(uiAction: UiAction) {
        viewModelScope.launch {
            when (uiAction) {
                UiAction.OnSkipClick -> navigateTo(Screen.Login, Screen.Onboarding)
            }
        }
    }
}