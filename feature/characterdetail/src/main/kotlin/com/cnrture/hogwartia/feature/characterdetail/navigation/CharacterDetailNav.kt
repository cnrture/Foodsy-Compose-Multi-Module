package com.cnrture.hogwartia.feature.characterdetail.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.canerture.hogwartia.ui.delegate.navigator.NavigationClientCollector
import com.cnrture.hogwartia.feature.characterdetail.CharacterDetailScreen
import com.cnrture.hogwartia.feature.characterdetail.CharacterDetailViewModel

@Composable
fun CharacterDetailRoute() {
    val viewModel = hiltViewModel<CharacterDetailViewModel>()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val uiEffect = viewModel.uiEffect
    NavigationClientCollector(viewModel.navigationClientEffect)
    CharacterDetailScreen(
        uiState = uiState,
        uiEffect = uiEffect,
        onAction = viewModel::onAction,
    )
}