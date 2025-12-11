package com.canerture.home.feature.home

object HomeContract {
    data class UiState(
        val isLoading: Boolean = false,
    )

    sealed interface UiAction {
        data class OnFavoriteClick(val id: Int) : UiAction
        data class OnAddToCartClick(val id: Int) : UiAction
    }

    sealed interface UiEffect
}