package com.canerture.home.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.canerture.home.feature.home.HomeContract.UiAction
import com.canerture.home.feature.home.HomeContract.UiEffect
import com.canerture.home.feature.home.HomeContract.UiState
import com.canerture.ui.delegate.mvi.MVI
import com.canerture.ui.delegate.mvi.mvi
import com.canerture.ui.delegate.navigator.NavigationClient
import com.canerture.ui.delegate.navigator.navigationClient
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() :
    ViewModel(),
    MVI<UiState, UiAction, UiEffect> by mvi(UiState()),
    NavigationClient by navigationClient() {

    override fun onAction(uiAction: UiAction) {
        viewModelScope.launch {
            when (uiAction) {
                is UiAction.OnFavoriteClick -> handleFavoriteClick(uiAction.id)
                is UiAction.OnAddToCartClick -> addToCart(uiAction.id)
            }
        }
    }

    private fun handleFavoriteClick(id: Int) = viewModelScope.launch {
        // Implementation for handling favorite click
    }

    private fun addToCart(id: Int) = viewModelScope.launch {
        // Implementation for adding item to cart
    }
}