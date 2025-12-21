package com.cnrture.foodsy.forgotpassword.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.canerture.ui.delegate.navigator.NavigationClientCollector
import com.cnrture.foodsy.forgotpassword.ForgotPasswordScreen
import com.cnrture.foodsy.forgotpassword.ForgotPasswordViewModel

@Composable
fun ForgotPasswordRoute() {
    val viewModel = hiltViewModel<ForgotPasswordViewModel>()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val uiEffect = viewModel.uiEffect
    NavigationClientCollector(viewModel.navigationClientEffect)
    ForgotPasswordScreen(
        uiState = uiState,
        uiEffect = uiEffect,
        onAction = viewModel::onAction,
    )
}