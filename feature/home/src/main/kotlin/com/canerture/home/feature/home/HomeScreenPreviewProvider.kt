package com.canerture.home.feature.home

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class HomeScreenPreviewProvider : PreviewParameterProvider<HomeContract.UiState> {
    override val values: Sequence<HomeContract.UiState>
        get() = sequenceOf(
            HomeContract.UiState(
                isLoading = true,
            ),
            HomeContract.UiState(
                isLoading = false,
            ),
        )
}