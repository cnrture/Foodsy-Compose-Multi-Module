package com.cnrture.foodsy.ui.register

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class RegisterScreenPreviewProvider : PreviewParameterProvider<RegisterContract.UiState> {
    override val values: Sequence<RegisterContract.UiState>
        get() = sequenceOf(
            RegisterContract.UiState(
                isLoading = true,
                list = emptyList(),
            ),
            RegisterContract.UiState(
                isLoading = false,
                list = emptyList(),
            ),
            RegisterContract.UiState(
                isLoading = false,
                list = listOf("Item 1", "Item 2", "Item 3")
            ),
        )
}