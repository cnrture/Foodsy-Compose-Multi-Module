package com.cnrture.hogwartia.feature.houses

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class HousesScreenPreviewProvider : PreviewParameterProvider<HousesContract.UiState> {
    override val values: Sequence<HousesContract.UiState>
        get() = sequenceOf(
            HousesContract.UiState(
                isLoading = true,
                list = emptyList(),
            ),
            HousesContract.UiState(
                isLoading = false,
                list = emptyList(),
            ),
            HousesContract.UiState(
                isLoading = false,
                list = listOf("Item 1", "Item 2", "Item 3")
            ),
        )
}