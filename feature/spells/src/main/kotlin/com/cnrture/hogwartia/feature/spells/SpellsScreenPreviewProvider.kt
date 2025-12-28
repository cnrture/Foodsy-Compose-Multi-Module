package com.cnrture.hogwartia.feature.spells

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class SpellsScreenPreviewProvider : PreviewParameterProvider<SpellsContract.UiState> {
    override val values: Sequence<SpellsContract.UiState>
        get() = sequenceOf(
            SpellsContract.UiState(
                isLoading = true,
                list = emptyList(),
            ),
            SpellsContract.UiState(
                isLoading = false,
                list = emptyList(),
            ),
            SpellsContract.UiState(
                isLoading = false,
                list = listOf("Item 1", "Item 2", "Item 3")
            ),
        )
}