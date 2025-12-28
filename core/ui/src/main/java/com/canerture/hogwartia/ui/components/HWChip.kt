package com.canerture.hogwartia.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.canerture.hogwartia.ui.theme.HWTheme

@Composable
fun HWChip(
    modifier: Modifier = Modifier,
    selected: Boolean,
    onClick: () -> Unit,
    label: String,
) {
    FilterChip(
        modifier = modifier,
        selected = selected,
        onClick = onClick,
        label = {
            HWText(
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
                text = label,
                style = TextStyle(
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium,
                ),
                color = if (selected) HWTheme.colors.white else HWTheme.colors.darkBrown,
            )
        },
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(
            width = 1.dp,
            color = if (selected) HWTheme.colors.green else HWTheme.colors.lightBrown,
        ),
        colors = FilterChipDefaults.filterChipColors(
            containerColor = Color.Transparent,
            selectedContainerColor = HWTheme.colors.green,
        ),
    )
}

@Preview(showBackground = true)
@Composable
fun HWChipPreview() {
    HWTheme {
        HWChip(
            selected = true,
            onClick = {},
            label = "Sample Chip",
        )
    }
}