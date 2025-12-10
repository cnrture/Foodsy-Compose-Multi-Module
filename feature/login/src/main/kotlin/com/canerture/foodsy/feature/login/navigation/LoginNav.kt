package com.canerture.foodsy.feature.login.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.canerture.foodsy.feature.login.LoginScreen
import com.canerture.foodsy.feature.login.LoginViewModel
import com.canerture.ui.navigation.Screen
import kotlinx.serialization.Serializable

@Serializable
data object LoginRoute : Screen

@Composable
fun LoginRoute(
    onNavigateHome: () -> Unit,
) {
    val viewModel = hiltViewModel<LoginViewModel>()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val uiEffect = viewModel.uiEffect
    LoginScreen(
        uiState = uiState,
        uiEffect = uiEffect,
        onAction = viewModel::onAction,
        onNavigateHome = onNavigateHome,
    )
}