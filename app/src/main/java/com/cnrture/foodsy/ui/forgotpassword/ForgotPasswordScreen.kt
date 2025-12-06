package com.cnrture.foodsy.ui.forgotpassword

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.sp
import com.cnrture.foodsy.common.collectWithLifecycle
import com.cnrture.foodsy.ui.forgotpassword.ForgotPasswordContract.UiAction
import com.cnrture.foodsy.ui.forgotpassword.ForgotPasswordContract.UiEffect
import com.cnrture.foodsy.ui.forgotpassword.ForgotPasswordContract.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun ForgotPasswordScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
) {
    uiEffect.collectWithLifecycle {}

    ForgotPasswordContent(
        modifier = Modifier.fillMaxSize(),
        uiState = uiState,
        onAction = onAction,
    )
}

@Composable
fun ForgotPasswordContent(
    modifier: Modifier = Modifier,
    uiState: UiState,
    onAction: (UiAction) -> Unit,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "ForgotPassword Content",
            fontSize = 24.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ForgotPasswordScreenPreview(
    @PreviewParameter(ForgotPasswordScreenPreviewProvider::class) uiState: UiState,
) {
    ForgotPasswordScreen(
        uiState = uiState,
        uiEffect = emptyFlow(),
        onAction = {},
    )
}