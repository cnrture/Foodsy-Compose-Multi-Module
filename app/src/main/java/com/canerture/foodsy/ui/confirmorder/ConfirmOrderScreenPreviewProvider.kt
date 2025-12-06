package com.canerture.foodsy.ui.confirmorder

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class ConfirmOrderScreenPreviewProvider : PreviewParameterProvider<ConfirmOrderContract.UiState> {
    override val values: Sequence<ConfirmOrderContract.UiState>
        get() = sequenceOf(
            ConfirmOrderContract.UiState(
                isLoading = true,
                list = emptyList(),
            ),
            ConfirmOrderContract.UiState(
                isLoading = false,
                list = emptyList(),
            ),
            ConfirmOrderContract.UiState(
                isLoading = false,
                list = listOf("Item 1", "Item 2", "Item 3")
            ),
        )
}