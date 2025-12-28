package com.cnrture.hogwartia.feature.spells.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.canerture.hogwartia.ui.delegate.navigator.NavigationClientCollector
import com.cnrture.hogwartia.feature.spells.SpellsScreen
import com.cnrture.hogwartia.feature.spells.SpellsViewModel

@Composable
fun SpellsRoute() {
    val viewModel = hiltViewModel<SpellsViewModel>()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val uiEffect = viewModel.uiEffect
    NavigationClientCollector(viewModel.navigationClientEffect)
    SpellsScreen(
        uiState = uiState,
        uiEffect = uiEffect,
        onAction = viewModel::onAction,
    )
}