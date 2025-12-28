package com.cnrture.hogwartia.feature.cart.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.canerture.ui.delegate.navigator.NavigationClientCollector
import com.cnrture.hogwartia.feature.cart.CartScreen
import com.cnrture.hogwartia.feature.cart.CartViewModel

@Composable
fun CartRoute() {
    val viewModel = hiltViewModel<CartViewModel>()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val uiEffect = viewModel.uiEffect
    NavigationClientCollector(viewModel.navigationClientEffect)
    CartScreen(
        uiState = uiState,
        uiEffect = uiEffect,
        onAction = viewModel::onAction,
    )
}