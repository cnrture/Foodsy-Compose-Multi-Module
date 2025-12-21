package com.cnrture.foodsy.feature.confirmorder

object ConfirmOrderContract {
    data class UiState(
        val isLoading: Boolean = false,
        val list: List<String> = emptyList(),
    )

    sealed interface UiAction

    sealed interface UiEffect
}