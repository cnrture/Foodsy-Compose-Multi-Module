package com.cnrture.foodsy.feature.favorites

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
import com.cnrture.foodsy.feature.favorites.FavoritesContract.UiAction
import com.cnrture.foodsy.feature.favorites.FavoritesContract.UiEffect
import com.cnrture.foodsy.feature.favorites.FavoritesContract.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun FavoritesScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
) {
    uiEffect.collectWithLifecycle {}

    FavoritesContent(
        modifier = Modifier.fillMaxSize(),
        uiState = uiState,
        onAction = onAction,
    )
}

@Composable
fun FavoritesContent(
    modifier: Modifier = Modifier,
    uiState: UiState,
    onAction: (UiAction) -> Unit,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "Favorites Content",
            fontSize = 24.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FavoritesScreenPreview(
    @PreviewParameter(FavoritesScreenPreviewProvider::class) uiState: UiState,
) {
    FavoritesScreen(
        uiState = uiState,
        uiEffect = emptyFlow(),
        onAction = {},
    )
}