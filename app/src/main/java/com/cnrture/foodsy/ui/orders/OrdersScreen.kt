package com.cnrture.foodsy.ui.orders

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
import com.cnrture.foodsy.ui.orders.OrdersContract.UiAction
import com.cnrture.foodsy.ui.orders.OrdersContract.UiEffect
import com.cnrture.foodsy.ui.orders.OrdersContract.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun OrdersScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
) {
    uiEffect.collectWithLifecycle {}

    OrdersContent(
        modifier = Modifier.fillMaxSize(),
        uiState = uiState,
        onAction = onAction,
    )
}

@Composable
fun OrdersContent(
    modifier: Modifier = Modifier,
    uiState: UiState,
    onAction: (UiAction) -> Unit,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "Orders Content",
            fontSize = 24.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OrdersScreenPreview(
    @PreviewParameter(OrdersScreenPreviewProvider::class) uiState: UiState,
) {
    OrdersScreen(
        uiState = uiState,
        uiEffect = emptyFlow(),
        onAction = {},
    )
}