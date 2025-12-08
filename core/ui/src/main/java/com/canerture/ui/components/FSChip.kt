package com.canerture.ui.components

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
import com.canerture.ui.theme.FSTheme

@Composable
fun FSChip(
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
            FSText(
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
                text = label,
                style = TextStyle(
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium,
                ),
                color = if (selected) FSTheme.colors.white else FSTheme.colors.darkBrown,
            )
        },
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(
            width = 1.dp,
            color = if (selected) FSTheme.colors.green else FSTheme.colors.lightBrown,
        ),
        colors = FilterChipDefaults.filterChipColors(
            containerColor = Color.Transparent,
            selectedContainerColor = FSTheme.colors.green,
        ),
    )
}

@Preview(showBackground = true)
@Composable
fun FSChipPreview() {
    FSTheme {
        FSChip(
            selected = true,
            onClick = {},
            label = "Sample Chip",
        )
    }
}