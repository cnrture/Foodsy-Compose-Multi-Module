package com.canerture.hogwartia.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.launch

@Composable
fun HWScreen(
    isLoading: Boolean = false,
    content: @Composable (PaddingValues) -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        content = { paddingValues ->
            content(paddingValues)
        }
    )

    if (isLoading) HWLoading()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HWScreenWithSheet(
    isLoading: Boolean = false,
    isSheetOpen: Boolean = false,
    skipPartiallyExpanded: Boolean = false,
    containerColor: Color = MaterialTheme.colorScheme.background,
    sheetContent: @Composable () -> Unit,
    onDismissSheet: () -> Unit,
    content: @Composable () -> Unit,
) {
    var openBottomSheet by rememberSaveable { mutableStateOf(false) }
    val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = skipPartiallyExpanded)
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(isSheetOpen) {
        if (isSheetOpen) {
            coroutineScope.launch {
                openBottomSheet = true
                bottomSheetState.show()
            }
        } else {
            coroutineScope.launch { bottomSheetState.hide() }
                .invokeOnCompletion {
                    if (!bottomSheetState.isVisible) {
                        openBottomSheet = false
                    }
                }
        }
    }

    content()

    if (openBottomSheet) {
        ModalBottomSheet(
            modifier = Modifier.navigationBarsPadding(),
            onDismissRequest = { onDismissSheet() },
            sheetState = bottomSheetState,
            containerColor = containerColor,
            dragHandle = null
        ) {
            sheetContent()
        }
    }

    if (isLoading) HWLoading()
}