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
import com.canerture.hogwartia.ui.theme.FSTheme

enum class FSButtonType { PRIMARY, SECONDARY, OUTLINED }

enum class FSButtonSize { SMALL, MEDIUM }

@Composable
fun FSButton(
    modifier: Modifier = Modifier,
    text: String,
    isEnable: Boolean = true,
    type: FSButtonType = FSButtonType.PRIMARY,
    size: FSButtonSize = FSButtonSize.MEDIUM,
    icon: ImageVector? = null,
    onClick: () -> Unit,
) {
    val textStyle = when (size) {
        FSButtonSize.SMALL -> TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily(
                Font(R.font.noto_regular, FontWeight.Normal),
                Font(R.font.noto_semibold, FontWeight.SemiBold),
                Font(R.font.noto_bold, FontWeight.Bold),
            ),
        )

        FSButtonSize.MEDIUM -> TextStyle(
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
        FSButtonSize.SMALL -> 40.dp
        FSButtonSize.MEDIUM -> 50.dp
    }

    val paddingValues = when (size) {
        FSButtonSize.SMALL -> PaddingValues(horizontal = 20.dp, vertical = 8.dp)
        FSButtonSize.MEDIUM -> PaddingValues(horizontal = 20.dp, vertical = 12.dp)
    }

    when (type) {
        FSButtonType.PRIMARY -> {
            Button(
                modifier = Modifier
                    .then(modifier)
                    .height(height),
                onClick = onClick,
                enabled = isEnable,
                colors = ButtonDefaults.buttonColors(
                    containerColor = FSTheme.colors.green,
                    disabledContainerColor = FSTheme.colors.green.copy(alpha = 0.2f),
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
                FSText(
                    text = text,
                    color = FSTheme.colors.white,
                    style = textStyle,
                )
            }
        }

        FSButtonType.SECONDARY -> {
            Button(
                modifier = Modifier
                    .height(height)
                    .then(modifier),
                onClick = onClick,
                enabled = isEnable,
                colors = ButtonDefaults.buttonColors(FSTheme.colors.orange),
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
                FSText(
                    text = text,
                    color = FSTheme.colors.white,
                    style = textStyle,
                )
            }
        }

        FSButtonType.OUTLINED -> {
            Button(
                modifier = Modifier
                    .height(height)
                    .then(modifier),
                onClick = onClick,
                enabled = isEnable,
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(width = 1.dp, color = FSTheme.colors.beige),
                contentPadding = paddingValues,
            ) {
                FSText(
                    text = text,
                    color = FSTheme.colors.brown,
                    style = textStyle,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FSButtonPreview() {
    FSTheme {
        Column {
            FSButton(
                text = "Primary Button",
                type = FSButtonType.PRIMARY,
                size = FSButtonSize.SMALL,
                onClick = { }
            )
            Spacer(modifier = Modifier.height(16.dp))
            FSButton(
                text = "Outlined Button",
                type = FSButtonType.OUTLINED,
                size = FSButtonSize.SMALL,
                onClick = { }
            )
            Spacer(modifier = Modifier.height(16.dp))
            FSButton(
                text = "Primary Button",
                type = FSButtonType.PRIMARY,
                size = FSButtonSize.MEDIUM,
                onClick = { }
            )
            Spacer(modifier = Modifier.height(16.dp))
            FSButton(
                text = "Primary Button",
                type = FSButtonType.SECONDARY,
                size = FSButtonSize.SMALL,
                onClick = { }
            )
            Spacer(modifier = Modifier.height(16.dp))
            FSButton(
                text = "Outlined Button",
                type = FSButtonType.OUTLINED,
                size = FSButtonSize.SMALL,
                icon = FSTheme.icons.google,
                onClick = { }
            )
            Spacer(modifier = Modifier.height(16.dp))
            FSButton(
                text = "Primary Button",
                type = FSButtonType.SECONDARY,
                size = FSButtonSize.MEDIUM,
                icon = FSTheme.icons.google,
                onClick = { }
            )
        }
    }
}