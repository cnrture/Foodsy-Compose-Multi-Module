package com.cnrture.hogwartia.feature.spelldetail

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class SpellDetailScreenPreviewProvider : PreviewParameterProvider<SpellDetailContract.UiState> {
    override val values: Sequence<SpellDetailContract.UiState>
        get() = sequenceOf(
            SpellDetailContract.UiState(
                isLoading = true,
                list = emptyList(),
            ),
            SpellDetailContract.UiState(
                isLoading = false,
                list = emptyList(),
            ),
            SpellDetailContract.UiState(
                isLoading = false,
                list = listOf("Item 1", "Item 2", "Item 3")
            ),
        )
}