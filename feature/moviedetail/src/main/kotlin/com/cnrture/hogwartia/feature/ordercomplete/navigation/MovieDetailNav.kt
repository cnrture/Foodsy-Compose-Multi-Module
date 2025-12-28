package com.cnrture.hogwartia.feature.ordercomplete.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.canerture.hogwartia.ui.delegate.navigator.NavigationClientCollector
import com.cnrture.hogwartia.feature.ordercomplete.MovieDetailScreen
import com.cnrture.hogwartia.feature.ordercomplete.MovieDetailViewModel

@Composable
fun MovieDetailRoute() {
    val viewModel = hiltViewModel<MovieDetailViewModel>()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val uiEffect = viewModel.uiEffect
    NavigationClientCollector(viewModel.navigationClientEffect)
    MovieDetailScreen(
        uiState = uiState,
        uiEffect = uiEffect,
        onAction = viewModel::onAction,
    )
}