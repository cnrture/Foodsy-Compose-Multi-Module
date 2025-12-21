package com.cnrture.foodsy.feature.confirmorder.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.canerture.ui.delegate.navigator.NavigationClientCollector
import com.cnrture.foodsy.feature.confirmorder.ConfirmOrderScreen
import com.cnrture.foodsy.feature.confirmorder.ConfirmOrderViewModel

@Composable
fun ConfirmOrderRoute() {
    val viewModel = hiltViewModel<ConfirmOrderViewModel>()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val uiEffect = viewModel.uiEffect
    NavigationClientCollector(viewModel.navigationClientEffect)
    ConfirmOrderScreen(
        uiState = uiState,
        uiEffect = uiEffect,
        onAction = viewModel::onAction,
    )
}