package com.canerture.hogwartia.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.canerture.hogwartia.ui.R
import com.canerture.hogwartia.ui.theme.HWTheme

enum class HWButtonType { PRIMARY, SECONDARY }

enum class HWButtonSize { SMALL, MEDIUM }

@Composable
fun HWButton(
    modifier: Modifier = Modifier,
    text: String,
    isEnable: Boolean = true,
    type: HWButtonType = HWButtonType.PRIMARY,
    size: HWButtonSize = HWButtonSize.MEDIUM,
    icon: ImageVector? = null,
    containerColor: Color = HWTheme.colors.purple,
    contentColor: Color = HWTheme.colors.white,
    onClick: () -> Unit,
) {
    val textStyle = when (size) {
        HWButtonSize.SMALL -> TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
        )

        HWButtonSize.MEDIUM -> TextStyle(
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
        )
    }

    val height = when (size) {
        HWButtonSize.SMALL -> 40.dp
        HWButtonSize.MEDIUM -> 50.dp
    }

    val paddingValues = when (size) {
        HWButtonSize.SMALL -> PaddingValues(horizontal = 20.dp, vertical = 8.dp)
        HWButtonSize.MEDIUM -> PaddingValues(horizontal = 20.dp, vertical = 12.dp)
    }

    when (type) {
        HWButtonType.PRIMARY -> {
            Button(
                modifier = Modifier
                    .then(modifier)
                    .height(height),
                onClick = onClick,
                enabled = isEnable,
                colors = ButtonDefaults.buttonColors(
                    containerColor = containerColor,
                    disabledContainerColor = containerColor.copy(alpha = 0.2f),
                ),
                shape = RoundedCornerShape(8.dp),
                contentPadding = paddingValues,
            ) {
                icon?.let {
                    Icon(
                        modifier = Modifier.size(14.dp),
                        imageVector = icon,
                        tint = Color.Unspecified,
                        contentDescription = text,
                    )
                    Spacer(modifier = Modifier.width(14.dp))
                }
                HWText(
                    text = text,
                    color = contentColor,
                    style = textStyle,
                )
            }
        }

        HWButtonType.SECONDARY -> {
            Button(
                modifier = Modifier
                    .height(height)
                    .then(modifier),
                onClick = onClick,
                enabled = isEnable,
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(width = 1.dp, color = containerColor),
                contentPadding = paddingValues,
            ) {
                HWText(
                    text = text,
                    color = contentColor,
                    style = textStyle,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HWButtonPreview() {
    HWTheme {
        Column {
            HWButton(
                text = "Primary Button",
                type = HWButtonType.PRIMARY,
                size = HWButtonSize.SMALL,
                onClick = { }
            )
            Spacer(modifier = Modifier.height(16.dp))
            HWButton(
                text = "Primary Button",
                type = HWButtonType.PRIMARY,
                size = HWButtonSize.MEDIUM,
                onClick = { }
            )
            Spacer(modifier = Modifier.height(16.dp))
            HWButton(
                text = "Secondary Button",
                type = HWButtonType.SECONDARY,
                size = HWButtonSize.SMALL,
                contentColor = HWTheme.colors.purple,
                onClick = { }
            )
            Spacer(modifier = Modifier.height(16.dp))
            HWButton(
                text = "Secondary Button",
                type = HWButtonType.SECONDARY,
                size = HWButtonSize.MEDIUM,
                icon = HWTheme.icons.google,
                contentColor = HWTheme.colors.purple,
                onClick = { }
            )
        }
    }
}