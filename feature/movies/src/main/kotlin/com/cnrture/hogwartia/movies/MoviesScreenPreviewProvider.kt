package com.cnrture.hogwartia.movies

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class MoviesScreenPreviewProvider : PreviewParameterProvider<MoviesContract.UiState> {
    override val values: Sequence<MoviesContract.UiState>
        get() = sequenceOf(
            MoviesContract.UiState(
                isLoading = true,
                list = emptyList(),
            ),
            MoviesContract.UiState(
                isLoading = false,
                list = emptyList(),
            ),
            MoviesContract.UiState(
                isLoading = false,
                list = listOf("Item 1", "Item 2", "Item 3")
            ),
        )
}