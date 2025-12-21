package com.cnrture.foodsy.feature.discount

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.sp
import com.canerture.ui.extensions.collectWithLifecycle
import com.cnrture.foodsy.feature.discount.DiscountContract.UiAction
import com.cnrture.foodsy.feature.discount.DiscountContract.UiEffect
import com.cnrture.foodsy.feature.discount.DiscountContract.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun DiscountScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
) {
    uiEffect.collectWithLifecycle {}

    DiscountContent(
        modifier = Modifier.fillMaxSize(),
        uiState = uiState,
        onAction = onAction,
    )
}

@Composable
fun DiscountContent(
    modifier: Modifier = Modifier,
    uiState: UiState,
    onAction: (UiAction) -> Unit,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "Discount Content",
            fontSize = 24.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DiscountScreenPreview(
    @PreviewParameter(DiscountScreenPreviewProvider::class) uiState: UiState,
) {
    DiscountScreen(
        uiState = uiState,
        uiEffect = emptyFlow(),
        onAction = {},
    )
}