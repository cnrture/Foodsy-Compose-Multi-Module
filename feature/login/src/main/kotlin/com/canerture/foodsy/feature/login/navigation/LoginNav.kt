package com.canerture.foodsy.feature.login.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.canerture.foodsy.feature.login.LoginScreen
import com.canerture.foodsy.feature.login.LoginViewModel
import com.canerture.ui.delegate.navigator.NavigationClientCollector

@Composable
fun LoginRoute() {
    val viewModel = hiltViewModel<LoginViewModel>()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val uiEffect = viewModel.uiEffect
    NavigationClientCollector(viewModel.navigationClientEffect)
    LoginScreen(
        uiState = uiState,
        uiEffect = uiEffect,
        onAction = viewModel::onAction,
    )
}