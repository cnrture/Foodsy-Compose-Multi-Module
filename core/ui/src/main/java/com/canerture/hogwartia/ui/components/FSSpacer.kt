package com.canerture.hogwartia.ui.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FSSpacer(size: Int) {
    Spacer(
        modifier = Modifier.size(size.dp)
    )
}

@Composable
fun RowScope.FSSpacerWeight(weight: Float) {
    Spacer(
        modifier = Modifier.weight(weight),
    )
}

@Composable
fun ColumnScope.FSSpacerWeight(weight: Float) {
    Spacer(
        modifier = Modifier.weight(weight),
    )
}