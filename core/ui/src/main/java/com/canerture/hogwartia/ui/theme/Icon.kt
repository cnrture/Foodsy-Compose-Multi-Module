package com.canerture.hogwartia.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.canerture.hogwartia.ui.R

internal val LocalIcons = staticCompositionLocalOf { HWIcons() }

class HWIcons {
    val visibilityOn: ImageVector
        @Composable
        get() = ImageVector.vectorResource(id = R.drawable.ic_visibility_on)

    val visibilityOff: ImageVector
        @Composable
        get() = ImageVector.vectorResource(id = R.drawable.ic_visibility_off)
}