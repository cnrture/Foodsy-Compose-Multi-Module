package com.cnrture.hogwartia.feature.search

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.sp
import com.canerture.hogwartia.ui.extensions.collectWithLifecycle
import com.cnrture.hogwartia.feature.search.SearchContract.UiAction
import com.cnrture.hogwartia.feature.search.SearchContract.UiEffect
import com.cnrture.hogwartia.feature.search.SearchContract.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun SearchScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
) {
    uiEffect.collectWithLifecycle {}

    SearchContent(
        modifier = Modifier.fillMaxSize(),
        uiState = uiState,
        onAction = onAction,
    )
}

@Composable
fun SearchContent(
    modifier: Modifier = Modifier,
    uiState: UiState,
    onAction: (UiAction) -> Unit,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "Search Content",
            fontSize = 24.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview(
    @PreviewParameter(SearchScreenPreviewProvider::class) uiState: UiState,
) {
    SearchScreen(
        uiState = uiState,
        uiEffect = emptyFlow(),
        onAction = {},
    )
}