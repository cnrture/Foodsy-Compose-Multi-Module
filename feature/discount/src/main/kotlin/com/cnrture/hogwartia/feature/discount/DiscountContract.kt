package com.cnrture.hogwartia.feature.discount

object DiscountContract {
    data class UiState(
        val isLoading: Boolean = false,
        val list: List<String> = emptyList(),
    )

    sealed interface UiAction

    sealed interface UiEffect
}