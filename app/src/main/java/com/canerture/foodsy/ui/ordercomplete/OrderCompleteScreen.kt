package com.canerture.foodsy.ui.ordercomplete

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
import com.canerture.foodsy.ui.ordercomplete.OrderCompleteContract.UiAction
import com.canerture.foodsy.ui.ordercomplete.OrderCompleteContract.UiEffect
import com.canerture.foodsy.ui.ordercomplete.OrderCompleteContract.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun OrderCompleteScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
) {
    uiEffect.collectWithLifecycle {}

    OrderCompleteContent(
        modifier = Modifier.fillMaxSize(),
        uiState = uiState,
        onAction = onAction,
    )
}

@Composable
fun OrderCompleteContent(
    modifier: Modifier = Modifier,
    uiState: UiState,
    onAction: (UiAction) -> Unit,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "OrderComplete Content",
            fontSize = 24.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OrderCompleteScreenPreview(
    @PreviewParameter(OrderCompleteScreenPreviewProvider::class) uiState: UiState,
) {
    OrderCompleteScreen(
        uiState = uiState,
        uiEffect = emptyFlow(),
        onAction = {},
    )
}