package com.canerture.foodsy.feature.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.canerture.foodsy.feature.splash.SplashContract.UiEffect
import com.canerture.ui.delegate.mvi.MVI
import com.canerture.ui.delegate.mvi.mvi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class SplashViewModel @Inject constructor() :
    ViewModel(),
    MVI<Unit, Unit, UiEffect> by mvi(Unit) {

    init {
        viewModelScope.launch {
            delay(2000)
            emitUiEffect(UiEffect.NavigateToOnboarding)
        }
    }
}