package com.canerture.foodsy.ui.submenu

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class SubmenuScreenPreviewProvider : PreviewParameterProvider<SubmenuContract.UiState> {
    override val values: Sequence<SubmenuContract.UiState>
        get() = sequenceOf(
            SubmenuContract.UiState(
                isLoading = true,
                list = emptyList(),
            ),
            SubmenuContract.UiState(
                isLoading = false,
                list = emptyList(),
            ),
            SubmenuContract.UiState(
                isLoading = false,
                list = listOf("Item 1", "Item 2", "Item 3")
            ),
        )
}