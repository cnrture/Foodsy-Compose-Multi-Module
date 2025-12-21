package com.cnrture.foodsy.feature.discount.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.canerture.ui.delegate.navigator.NavigationClientCollector
import com.cnrture.foodsy.feature.discount.DiscountScreen
import com.cnrture.foodsy.feature.discount.DiscountViewModel

@Composable
fun DiscountRoute() {
    val viewModel = hiltViewModel<DiscountViewModel>()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val uiEffect = viewModel.uiEffect
    NavigationClientCollector(viewModel.navigationClientEffect)
    DiscountScreen(
        uiState = uiState,
        uiEffect = uiEffect,
        onAction = viewModel::onAction,
    )
}