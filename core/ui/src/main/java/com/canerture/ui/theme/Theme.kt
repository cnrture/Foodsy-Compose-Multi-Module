package com.canerture.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

object FSTheme {
    val colors: FSColor
        @Composable
        @ReadOnlyComposable
        get() = if (isSystemInDarkTheme()) LocalDarkColors.current else LocalLightColors.current

    val icons: FSIcons
        @Composable
        @ReadOnlyComposable
        get() = LocalIcons.current

    val typography: ESimTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current
}

@Composable
fun FSTheme(content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalLightColors provides FSTheme.colors,
        LocalIcons provides FSTheme.icons,
        LocalTypography provides FSTheme.typography,
    ) {
        content()
    }
}