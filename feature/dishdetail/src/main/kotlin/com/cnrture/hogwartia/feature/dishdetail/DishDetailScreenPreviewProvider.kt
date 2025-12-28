package com.cnrture.hogwartia.feature.dishdetail

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class DishDetailScreenPreviewProvider : PreviewParameterProvider<DishDetailContract.UiState> {
    override val values: Sequence<DishDetailContract.UiState>
        get() = sequenceOf(
            DishDetailContract.UiState(
                isLoading = true,
                list = emptyList(),
            ),
            DishDetailContract.UiState(
                isLoading = false,
                list = emptyList(),
            ),
            DishDetailContract.UiState(
                isLoading = false,
                list = listOf("Item 1", "Item 2", "Item 3")
            ),
        )
}