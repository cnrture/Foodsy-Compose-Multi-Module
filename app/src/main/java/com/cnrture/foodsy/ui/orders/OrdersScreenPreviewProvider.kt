package com.cnrture.foodsy.ui.orders

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class OrdersScreenPreviewProvider : PreviewParameterProvider<OrdersContract.UiState> {
    override val values: Sequence<OrdersContract.UiState>
        get() = sequenceOf(
            OrdersContract.UiState(
                isLoading = true,
                list = emptyList(),
            ),
            OrdersContract.UiState(
                isLoading = false,
                list = emptyList(),
            ),
            OrdersContract.UiState(
                isLoading = false,
                list = listOf("Item 1", "Item 2", "Item 3")
            ),
        )
}