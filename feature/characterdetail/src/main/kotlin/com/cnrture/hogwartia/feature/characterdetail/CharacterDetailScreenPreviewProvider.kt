package com.cnrture.hogwartia.feature.characterdetail

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class CharacterDetailScreenPreviewProvider : PreviewParameterProvider<CharacterDetailContract.UiState> {
    override val values: Sequence<CharacterDetailContract.UiState>
        get() = sequenceOf(
            CharacterDetailContract.UiState(
                isLoading = true,
                list = emptyList(),
            ),
            CharacterDetailContract.UiState(
                isLoading = false,
                list = emptyList(),
            ),
            CharacterDetailContract.UiState(
                isLoading = false,
                list = listOf("Item 1", "Item 2", "Item 3")
            ),
        )
}