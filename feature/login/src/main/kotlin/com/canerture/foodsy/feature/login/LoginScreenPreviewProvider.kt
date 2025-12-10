package com.canerture.foodsy.feature.login

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class LoginScreenPreviewProvider : PreviewParameterProvider<LoginContract.UiState> {
    override val values: Sequence<LoginContract.UiState>
        get() = sequenceOf(
            LoginContract.UiState(
                isLoading = true,
            ),
            LoginContract.UiState(
                isLoading = false,
            ),
            LoginContract.UiState(
                isLoading = false,
            ),
        )
}