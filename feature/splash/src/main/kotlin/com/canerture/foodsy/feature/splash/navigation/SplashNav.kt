package com.canerture.foodsy.feature.splash.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.canerture.foodsy.feature.splash.SplashScreen
import com.canerture.foodsy.feature.splash.SplashViewModel
import com.canerture.ui.delegate.navigator.NavigationClientCollector

@Composable
fun SplashRoute() {
    val viewModel = hiltViewModel<SplashViewModel>()
    val uiEffect = viewModel.uiEffect
    NavigationClientCollector(viewModel.navigationClientEffect)
    SplashScreen(
        uiEffect = uiEffect,
    )
}