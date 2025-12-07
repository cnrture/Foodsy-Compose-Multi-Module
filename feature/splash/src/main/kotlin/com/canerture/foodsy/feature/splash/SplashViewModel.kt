package com.canerture.foodsy.feature.splash

import androidx.lifecycle.ViewModel
import com.canerture.foodsy.feature.splash.SplashContract.UiEffect
import com.canerture.ui.delegate.mvi.MVI
import com.canerture.ui.delegate.mvi.mvi
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class SplashViewModel @Inject constructor() :
    ViewModel(),
    MVI<Unit, Unit, UiEffect> by mvi(Unit) {
}