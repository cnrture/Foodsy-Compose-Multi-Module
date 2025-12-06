package com.canerture.foodsy.ui.ordercomplete

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class OrderCompleteScreenPreviewProvider : PreviewParameterProvider<OrderCompleteContract.UiState> {
    override val values: Sequence<OrderCompleteContract.UiState>
        get() = sequenceOf(
            OrderCompleteContract.UiState(
                isLoading = true,
                list = emptyList(),
            ),
            OrderCompleteContract.UiState(
                isLoading = false,
                list = emptyList(),
            ),
            OrderCompleteContract.UiState(
                isLoading = false,
                list = listOf("Item 1", "Item 2", "Item 3")
            ),
        )
}