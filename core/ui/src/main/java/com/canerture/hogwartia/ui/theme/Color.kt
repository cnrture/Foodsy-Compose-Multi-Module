package com.canerture.hogwartia.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

internal val LocalLightColors = staticCompositionLocalOf { lightColors() }
internal val LocalDarkColors = staticCompositionLocalOf { darkColors() }

internal fun lightColors(
    gold: Color = Color(0xFFC5A059),
    black: Color = Color(0xFF050810),
    blue: Color = Color(0xFF1A2234),
    purple: Color = Color(0xFF7C3AED),
    white: Color = Color(0xFFFFFAF0),
): HWColor = HWColor(
    gold = gold,
    black = black,
    blue = blue,
    purple = purple,
    white = white,
)

internal fun darkColors(
    gold: Color = Color(0xFFC5A059),
    black: Color = Color(0xFF050810),
    blue: Color = Color(0xFF1A2234),
    purple: Color = Color(0xFF7C3AED),
    white: Color = Color(0xFFFFFAF0),
): HWColor = HWColor(
    gold = gold,
    black = black,
    blue = blue,
    purple = purple,
    white = white,
)

class HWColor(
    gold: Color,
    black: Color,
    blue: Color,
    purple: Color,
    white: Color,
) {
    var gold by mutableStateOf(gold)
        internal set
    var black by mutableStateOf(black)
        internal set
    var blue by mutableStateOf(blue)
        internal set
    var purple by mutableStateOf(purple)
        internal set
    var white by mutableStateOf(white)
        internal set
}