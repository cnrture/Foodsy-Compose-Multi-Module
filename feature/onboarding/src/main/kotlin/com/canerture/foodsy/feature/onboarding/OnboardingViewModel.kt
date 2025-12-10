package com.canerture.foodsy.feature.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.canerture.foodsy.feature.onboarding.OnboardingContract.UiAction
import com.canerture.foodsy.feature.onboarding.OnboardingContract.UiEffect
import com.canerture.ui.delegate.mvi.MVI
import com.canerture.ui.delegate.mvi.mvi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor() :
    ViewModel(),
    MVI<Unit, UiAction, UiEffect> by mvi(Unit) {

    override fun onAction(uiAction: UiAction) {
        viewModelScope.launch {
            when (uiAction) {
                UiAction.OnSkipClick -> emitUiEffect(UiEffect.NavigateLogin)
            }
        }
    }
}