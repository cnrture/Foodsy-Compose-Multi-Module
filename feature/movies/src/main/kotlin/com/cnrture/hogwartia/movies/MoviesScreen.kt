package com.cnrture.hogwartia.movies

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
import com.cnrture.hogwartia.movies.MoviesContract.UiAction
import com.cnrture.hogwartia.movies.MoviesContract.UiEffect
import com.cnrture.hogwartia.movies.MoviesContract.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun MoviesScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
) {
    uiEffect.collectWithLifecycle {}

    MoviesContent(
        modifier = Modifier.fillMaxSize(),
        uiState = uiState,
        onAction = onAction,
    )
}

@Composable
fun MoviesContent(
    modifier: Modifier = Modifier,
    uiState: UiState,
    onAction: (UiAction) -> Unit,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "Movies Content",
            fontSize = 24.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MoviesScreenPreview(
    @PreviewParameter(MoviesScreenPreviewProvider::class) uiState: UiState,
) {
    MoviesScreen(
        uiState = uiState,
        uiEffect = emptyFlow(),
        onAction = {},
    )
}