package com.canerture.hogwartia.feature.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.canerture.hogwartia.feature.splash.SplashContract.UiEffect
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
internal class SplashViewModel @Inject constructor() :
    ViewModel(),
    MVI<Unit, Unit, UiEffect> by mvi(Unit),
    NavigationClient by navigationClient() {

    init {
        viewModelScope.launch {
            delay(2000)
            navigateTo(Screen.Onboarding, Screen.Splash)
        }
    }
}