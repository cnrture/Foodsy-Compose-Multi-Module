package com.cnrture.hogwartia.feature.search.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.canerture.ui.delegate.navigator.NavigationClientCollector
import com.cnrture.hogwartia.feature.search.SearchScreen
import com.cnrture.hogwartia.feature.search.SearchViewModel

@Composable
fun SearchRoute() {
    val viewModel = hiltViewModel<SearchViewModel>()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val uiEffect = viewModel.uiEffect
    NavigationClientCollector(viewModel.navigationClientEffect)
    SearchScreen(
        uiState = uiState,
        uiEffect = uiEffect,
        onAction = viewModel::onAction,
    )
}