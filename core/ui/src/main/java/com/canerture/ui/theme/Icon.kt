package com.canerture.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.canerture.core.ui.R

internal val LocalIcons = staticCompositionLocalOf { FSIcons() }

class FSIcons {
    val arrowLeft: ImageVector
        @Composable
        get() = ImageVector.vectorResource(id = R.drawable.ic_launcher_background)
}