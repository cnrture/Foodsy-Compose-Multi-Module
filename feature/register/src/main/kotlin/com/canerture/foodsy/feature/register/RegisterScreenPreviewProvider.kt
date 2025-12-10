package com.canerture.foodsy.feature.register

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class RegisterScreenPreviewProvider : PreviewParameterProvider<RegisterContract.UiState> {
    override val values: Sequence<RegisterContract.UiState>
        get() = sequenceOf(
            RegisterContract.UiState(
                isLoading = true,
            ),
            RegisterContract.UiState(
                isLoading = false,
            ),
            RegisterContract.UiState(
                isLoading = false,
                username = "canerture",
                email = "cnrture@gmail.com",
                password = "password123",
            ),
        )
}