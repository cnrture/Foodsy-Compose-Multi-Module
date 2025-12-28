package com.canerture.hogwartia.ui.components

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
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
import com.canerture.hogwartia.ui.extensions.collectWithLifecycle
import com.canerture.hogwartia.ui.theme.FSTheme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

@Composable
fun <T> FSScreen(
    isLoading: Boolean = false,
    uiEffect: Flow<T>? = null,
    collectEffect: ((T) -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    uiEffect?.collectWithLifecycle {
        collectEffect?.invoke(it)
    }

    content()
    if (isLoading) FSLoading()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> FSScreenWithSheet(
    isLoading: Boolean = false,
    uiEffect: Flow<T>? = null,
    collectEffect: ((T) -> Unit)? = null,
    isSheetOpen: Boolean = false,
    skipPartiallyExpanded: Boolean = false,
    containerColor: Color = FSTheme.colors.white,
    sheetContent: @Composable () -> Unit,
    onDismissSheet: () -> Unit,
    content: @Composable () -> Unit,
) {
    uiEffect?.collectWithLifecycle {
        collectEffect?.invoke(it)
    }

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

    if (isLoading) FSLoading()
}