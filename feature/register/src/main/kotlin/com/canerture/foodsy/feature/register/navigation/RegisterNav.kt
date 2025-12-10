package com.canerture.foodsy.feature.register.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.canerture.foodsy.feature.register.RegisterScreen
import com.canerture.foodsy.feature.register.RegisterViewModel
import com.canerture.ui.navigation.Screen
import kotlinx.serialization.Serializable

@Serializable
data object RegisterRoute : Screen

@Composable
fun RegisterRoute(
    onNavigateHome: () -> Unit,
    onNavigateLogin: () -> Unit,
) {
    val viewModel = hiltViewModel<RegisterViewModel>()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val uiEffect = viewModel.uiEffect
    RegisterScreen(
        uiState = uiState,
        uiEffect = uiEffect,
        onAction = viewModel::onAction,
        onNavigateHome = onNavigateHome,
        onNavigateLogin = onNavigateLogin,
    )
}