package com.canerture.hogwartia.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

object HWTheme {
    val icons: HWIcons
        @Composable
        @ReadOnlyComposable
        get() = LocalIcons.current
}

@Composable
fun HWTheme(content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalIcons provides HWTheme.icons,
    ) {
        MaterialTheme(
            colorScheme = if (isSystemInDarkTheme()) DarkColors else LightColors,
            typography = HWTypography,
        ) {
            content()
        }
    }
}