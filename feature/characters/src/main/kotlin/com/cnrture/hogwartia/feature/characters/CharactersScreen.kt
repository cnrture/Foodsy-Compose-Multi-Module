package com.cnrture.hogwartia.feature.characters

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
import com.cnrture.hogwartia.feature.characters.CharactersContract.UiAction
import com.cnrture.hogwartia.feature.characters.CharactersContract.UiEffect
import com.cnrture.hogwartia.feature.characters.CharactersContract.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun CharactersScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
) {
    uiEffect.collectWithLifecycle {}

    CharactersContent(
        modifier = Modifier.fillMaxSize(),
        uiState = uiState,
        onAction = onAction,
    )
}

@Composable
fun CharactersContent(
    modifier: Modifier = Modifier,
    uiState: UiState,
    onAction: (UiAction) -> Unit,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "Characters Content",
            fontSize = 24.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CharactersScreenPreview(
    @PreviewParameter(CharactersScreenPreviewProvider::class) uiState: UiState,
) {
    CharactersScreen(
        uiState = uiState,
        uiEffect = emptyFlow(),
        onAction = {},
    )
}