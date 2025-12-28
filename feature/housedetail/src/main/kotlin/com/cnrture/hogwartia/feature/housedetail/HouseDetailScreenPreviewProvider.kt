package com.cnrture.hogwartia.feature.housedetail

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class HouseDetailScreenPreviewProvider : PreviewParameterProvider<HouseDetailContract.UiState> {
    override val values: Sequence<HouseDetailContract.UiState>
        get() = sequenceOf(
            HouseDetailContract.UiState(
                isLoading = true,
                list = emptyList(),
            ),
            HouseDetailContract.UiState(
                isLoading = false,
                list = emptyList(),
            ),
            HouseDetailContract.UiState(
                isLoading = false,
                list = listOf("Item 1", "Item 2", "Item 3")
            ),
        )
}