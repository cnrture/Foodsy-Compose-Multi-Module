package com.canerture.hogwartia.ui.components

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun HWIcon(
    modifier: Modifier = Modifier,
    vector: ImageVector,
    tint: Color = Color.Unspecified,
    contentDescription: String? = null,
) {
    Icon(
        modifier = modifier,
        imageVector = vector,
        tint = tint,
        contentDescription = contentDescription,
    )
}