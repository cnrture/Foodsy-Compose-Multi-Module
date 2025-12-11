package com.canerture.home.feature.home

object HomeContract {
    data class UiState(
        val isLoading: Boolean = false,
    )

    sealed interface UiAction

    sealed interface UiEffect
}