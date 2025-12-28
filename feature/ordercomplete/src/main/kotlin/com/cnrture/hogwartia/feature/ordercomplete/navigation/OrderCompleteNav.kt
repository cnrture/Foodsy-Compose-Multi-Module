package com.cnrture.hogwartia.feature.ordercomplete.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.canerture.ui.delegate.navigator.NavigationClientCollector
import com.cnrture.hogwartia.feature.ordercomplete.OrderCompleteScreen
import com.cnrture.hogwartia.feature.ordercomplete.OrderCompleteViewModel

@Composable
fun OrderCompleteRoute() {
    val viewModel = hiltViewModel<OrderCompleteViewModel>()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val uiEffect = viewModel.uiEffect
    NavigationClientCollector(viewModel.navigationClientEffect)
    OrderCompleteScreen(
        uiState = uiState,
        uiEffect = uiEffect,
        onAction = viewModel::onAction,
    )
}