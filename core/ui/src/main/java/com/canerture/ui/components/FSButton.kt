package com.canerture.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.canerture.ui.theme.FSTheme

enum class FSButtonType { PRIMARY, SECONDARY }

enum class FSButtonSize { EXTRA_SMALL, SMALL, MEDIUM, LARGE }

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
        FSButtonSize.EXTRA_SMALL -> FSTheme.typography.subheading3
        FSButtonSize.SMALL -> FSTheme.typography.heading6
        FSButtonSize.MEDIUM -> FSTheme.typography.heading5
        FSButtonSize.LARGE -> FSTheme.typography.heading4
    }

    val height = when (size) {
        FSButtonSize.EXTRA_SMALL -> 34.dp
        FSButtonSize.SMALL -> 53.dp
        FSButtonSize.MEDIUM -> 56.dp
        FSButtonSize.LARGE -> 59.dp
    }

    val paddingValues = when (size) {
        FSButtonSize.EXTRA_SMALL -> PaddingValues(vertical = 8.dp, horizontal = 16.dp)
        else -> PaddingValues(vertical = 16.dp, horizontal = 24.dp)
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
                    containerColor = FSTheme.colors.blue,
                    disabledContainerColor = FSTheme.colors.onBackground.copy(alpha = 0.2f),
                ),
                shape = CircleShape,
                border = BorderStroke(width = 2.dp, color = FSTheme.colors.onBackground),
                contentPadding = paddingValues,
            ) {
                icon?.let {
                    Icon(
                        imageVector = icon,
                        tint = Color.Unspecified,
                        contentDescription = text,
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
                FSText(
                    text = text,
                    color = FSTheme.colors.background,
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
                colors = ButtonDefaults.buttonColors(FSTheme.colors.background),
                shape = CircleShape,
                border = BorderStroke(width = 2.dp, color = FSTheme.colors.onBackground),
                contentPadding = paddingValues,
            ) {
                icon?.let {
                    Icon(
                        imageVector = icon,
                        tint = Color.Unspecified,
                        contentDescription = text,
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
                FSText(
                    text = text,
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
                type = FSButtonType.PRIMARY,
                size = FSButtonSize.MEDIUM,
                onClick = { }
            )
            Spacer(modifier = Modifier.height(16.dp))
            FSButton(
                text = "Primary Button",
                type = FSButtonType.PRIMARY,
                size = FSButtonSize.LARGE,
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
                type = FSButtonType.SECONDARY,
                size = FSButtonSize.MEDIUM,
                icon = FSTheme.icons.arrowLeft,
                onClick = { }
            )
            Spacer(modifier = Modifier.height(16.dp))
            FSButton(
                text = "Primary Button",
                type = FSButtonType.SECONDARY,
                size = FSButtonSize.LARGE,
                icon = FSTheme.icons.arrowLeft,
                onClick = { }
            )
        }
    }
}