package com.cnrture.hogwartia.feature.categories

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
import com.cnrture.hogwartia.feature.categories.CategoriesContract.UiAction
import com.cnrture.hogwartia.feature.categories.CategoriesContract.UiEffect
import com.cnrture.hogwartia.feature.categories.CategoriesContract.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun CategoriesScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
) {
    uiEffect.collectWithLifecycle {}

    CategoriesContent(
        modifier = Modifier.fillMaxSize(),
        uiState = uiState,
        onAction = onAction,
    )
}

@Composable
fun CategoriesContent(
    modifier: Modifier = Modifier,
    uiState: UiState,
    onAction: (UiAction) -> Unit,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "Categories Content",
            fontSize = 24.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CategoriesScreenPreview(
    @PreviewParameter(CategoriesScreenPreviewProvider::class) uiState: UiState,
) {
    CategoriesScreen(
        uiState = uiState,
        uiEffect = emptyFlow(),
        onAction = {},
    )
}