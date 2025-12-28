package com.cnrture.hogwartia.feature.spells

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
import com.cnrture.hogwartia.feature.spells.SpellsContract.UiAction
import com.cnrture.hogwartia.feature.spells.SpellsContract.UiEffect
import com.cnrture.hogwartia.feature.spells.SpellsContract.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun SpellsScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
) {
    uiEffect.collectWithLifecycle {}

    SpellsContent(
        modifier = Modifier.fillMaxSize(),
        uiState = uiState,
        onAction = onAction,
    )
}

@Composable
fun SpellsContent(
    modifier: Modifier = Modifier,
    uiState: UiState,
    onAction: (UiAction) -> Unit,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "Spells Content",
            fontSize = 24.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SpellsScreenPreview(
    @PreviewParameter(SpellsScreenPreviewProvider::class) uiState: UiState,
) {
    SpellsScreen(
        uiState = uiState,
        uiEffect = emptyFlow(),
        onAction = {},
    )
}