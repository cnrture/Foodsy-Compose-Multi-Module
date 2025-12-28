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

enum class HWButtonType { PRIMARY, SECONDARY, OUTLINED }

enum class HWButtonSize { SMALL, MEDIUM }

@Composable
fun HWButton(
    modifier: Modifier = Modifier,
    text: String,
    isEnable: Boolean = true,
    type: HWButtonType = HWButtonType.PRIMARY,
    size: HWButtonSize = HWButtonSize.MEDIUM,
    icon: ImageVector? = null,
    onClick: () -> Unit,
) {
    val textStyle = when (size) {
        HWButtonSize.SMALL -> TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily(
                Font(R.font.noto_regular, FontWeight.Normal),
                Font(R.font.noto_semibold, FontWeight.SemiBold),
                Font(R.font.noto_bold, FontWeight.Bold),
            ),
        )

        HWButtonSize.MEDIUM -> TextStyle(
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily(
                Font(R.font.noto_regular, FontWeight.Normal),
                Font(R.font.noto_semibold, FontWeight.SemiBold),
                Font(R.font.noto_bold, FontWeight.Bold),
            ),
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
                    containerColor = HWTheme.colors.green,
                    disabledContainerColor = HWTheme.colors.green.copy(alpha = 0.2f),
                ),
                shape = RoundedCornerShape(16.dp),
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
                    color = HWTheme.colors.white,
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
                colors = ButtonDefaults.buttonColors(HWTheme.colors.orange),
                shape = RoundedCornerShape(16.dp),
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
                    color = HWTheme.colors.white,
                    style = textStyle,
                )
            }
        }

        HWButtonType.OUTLINED -> {
            Button(
                modifier = Modifier
                    .height(height)
                    .then(modifier),
                onClick = onClick,
                enabled = isEnable,
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(width = 1.dp, color = HWTheme.colors.beige),
                contentPadding = paddingValues,
            ) {
                HWText(
                    text = text,
                    color = HWTheme.colors.brown,
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
                text = "Outlined Button",
                type = HWButtonType.OUTLINED,
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
                text = "Primary Button",
                type = HWButtonType.SECONDARY,
                size = HWButtonSize.SMALL,
                onClick = { }
            )
            Spacer(modifier = Modifier.height(16.dp))
            HWButton(
                text = "Outlined Button",
                type = HWButtonType.OUTLINED,
                size = HWButtonSize.SMALL,
                icon = HWTheme.icons.google,
                onClick = { }
            )
            Spacer(modifier = Modifier.height(16.dp))
            HWButton(
                text = "Primary Button",
                type = HWButtonType.SECONDARY,
                size = HWButtonSize.MEDIUM,
                icon = HWTheme.icons.google,
                onClick = { }
            )
        }
    }
}