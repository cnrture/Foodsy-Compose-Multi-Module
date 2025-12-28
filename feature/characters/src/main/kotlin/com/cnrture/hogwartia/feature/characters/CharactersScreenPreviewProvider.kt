package com.cnrture.hogwartia.feature.characters

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class CharactersScreenPreviewProvider : PreviewParameterProvider<CharactersContract.UiState> {
    override val values: Sequence<CharactersContract.UiState>
        get() = sequenceOf(
            CharactersContract.UiState(
                isLoading = true,
                list = emptyList(),
            ),
            CharactersContract.UiState(
                isLoading = false,
                list = emptyList(),
            ),
            CharactersContract.UiState(
                isLoading = false,
                list = listOf("Item 1", "Item 2", "Item 3")
            ),
        )
}