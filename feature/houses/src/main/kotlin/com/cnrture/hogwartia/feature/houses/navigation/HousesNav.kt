package com.cnrture.hogwartia.feature.houses.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.canerture.hogwartia.ui.delegate.navigator.NavigationClientCollector
import com.cnrture.hogwartia.feature.houses.HousesViewModel

@Composable
fun HousesRoute() {
    val viewModel = hiltViewModel<HousesViewModel>()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val uiEffect = viewModel.uiEffect
    NavigationClientCollector(viewModel.navigationClientEffect)
    HousesScreen(
        uiState = uiState,
        uiEffect = uiEffect,
        onAction = viewModel::onAction,
    )
}