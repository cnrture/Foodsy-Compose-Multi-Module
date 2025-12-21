package com.cnrture.foodsy.feature.categories

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class CategoriesScreenPreviewProvider : PreviewParameterProvider<CategoriesContract.UiState> {
    override val values: Sequence<CategoriesContract.UiState>
        get() = sequenceOf(
            CategoriesContract.UiState(
                isLoading = true,
                list = emptyList(),
            ),
            CategoriesContract.UiState(
                isLoading = false,
                list = emptyList(),
            ),
            CategoriesContract.UiState(
                isLoading = false,
                list = listOf("Item 1", "Item 2", "Item 3")
            ),
        )
}