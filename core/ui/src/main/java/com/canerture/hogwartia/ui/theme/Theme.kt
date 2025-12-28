package com.canerture.hogwartia.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

object HWTheme {
    val colors: HWColor
        @Composable
        @ReadOnlyComposable
        get() = if (isSystemInDarkTheme()) LocalDarkColors.current else LocalLightColors.current

    val icons: HWIcons
        @Composable
        @ReadOnlyComposable
        get() = LocalIcons.current

    val typography: HWTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current
}

@Composable
fun HWTheme(content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalLightColors provides HWTheme.colors,
        LocalIcons provides HWTheme.icons,
        LocalTypography provides HWTheme.typography,
    ) {
        content()
    }
}