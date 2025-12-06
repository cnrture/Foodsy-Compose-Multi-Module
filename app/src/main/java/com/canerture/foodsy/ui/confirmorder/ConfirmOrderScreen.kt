package com.canerture.foodsy.ui.confirmorder

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.sp
import com.canerture.foodsy.common.collectWithLifecycle
import com.canerture.foodsy.ui.confirmorder.ConfirmOrderContract.UiAction
import com.canerture.foodsy.ui.confirmorder.ConfirmOrderContract.UiEffect
import com.canerture.foodsy.ui.confirmorder.ConfirmOrderContract.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun ConfirmOrderScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
) {
    uiEffect.collectWithLifecycle {}

    ConfirmOrderContent(
        modifier = Modifier.fillMaxSize(),
        uiState = uiState,
        onAction = onAction,
    )
}

@Composable
fun ConfirmOrderContent(
    modifier: Modifier = Modifier,
    uiState: UiState,
    onAction: (UiAction) -> Unit,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "ConfirmOrder Content",
            fontSize = 24.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ConfirmOrderScreenPreview(
    @PreviewParameter(ConfirmOrderScreenPreviewProvider::class) uiState: UiState,
) {
    ConfirmOrderScreen(
        uiState = uiState,
        uiEffect = emptyFlow(),
        onAction = {},
    )
}