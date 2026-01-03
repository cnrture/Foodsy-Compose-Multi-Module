package com.canerture.hogwartia.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

internal val LocalLightColors = staticCompositionLocalOf { lightColors() }
internal val LocalDarkColors = staticCompositionLocalOf { darkColors() }

internal fun lightColors(
    yellow: Color = Color(0xFFD4AF36),
    black: Color = Color(0xFF202020),
    gray: Color = Color(0xFFB6B6B7),
    purple: Color = Color(0xFF161116),
    white: Color = Color(0xFFFEFEFE),
): HWColor = HWColor(
    yellow = yellow,
    black = black,
    gray = gray,
    purple = purple,
    white = white,
)

internal fun darkColors(
    yellow: Color = Color(0xFFD4AF36),
    black: Color = Color(0xFF202020),
    gray: Color = Color(0xFFB6B6B7),
    purple: Color = Color(0xFF161116),
    white: Color = Color(0xFFFEFEFE),
): HWColor = HWColor(
    yellow = yellow,
    black = black,
    gray = gray,
    purple = purple,
    white = white,
)

class HWColor(
    yellow: Color,
    black: Color,
    gray: Color,
    purple: Color,
    white: Color,
) {
    var yellow by mutableStateOf(yellow)
        internal set
    var black by mutableStateOf(black)
        internal set
    var gray by mutableStateOf(gray)
        internal set
    var purple by mutableStateOf(purple)
        internal set
    var white by mutableStateOf(white)
        internal set
}