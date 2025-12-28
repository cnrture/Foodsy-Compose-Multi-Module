package com.canerture.hogwartia.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.canerture.hogwartia.ui.extensions.conditional
import com.canerture.hogwartia.ui.extensions.noRippleClickable
import com.canerture.hogwartia.ui.theme.FSTheme

@Composable
fun FSTextField(
    modifier: Modifier = Modifier,
    value: String,
    label: String? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    isSingleLine: Boolean = true,
    isPassword: Boolean = false,
    icon: ImageVector? = null,
    onClick: (() -> Unit)? = null,
    onValueChange: (String) -> Unit,
) {
    var visibility by remember { mutableStateOf(false) }
    val visualTransformation = if (visibility) VisualTransformation.None else PasswordVisualTransformation()

    val trailingIcon: @Composable (() -> Unit)? = if (isPassword) {
        {
            FSIcon(
                modifier = Modifier
                    .size(24.dp)
                    .clickable { visibility = !visibility },
                vector = if (visibility) FSTheme.icons.visibilityOn else FSTheme.icons.visibilityOff,
                tint = FSTheme.colors.brown,
                contentDescription = label,
            )
        }
    } else if (icon != null) {
        {
            FSIcon(
                modifier = Modifier.size(20.dp),
                vector = icon,
                tint = FSTheme.colors.brown,
                contentDescription = label,
            )
        }
    } else {
        null
    }

    BasicTextField(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
            .clip(RoundedCornerShape(16.dp))
            .border(
                width = 1.dp,
                color = FSTheme.colors.beige,
                shape = RoundedCornerShape(16.dp),
            ),
        value = value,
        onValueChange = onValueChange,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
        ),
        textStyle = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            color = FSTheme.colors.brown,
        ),
        singleLine = isSingleLine,
        cursorBrush = SolidColor(value = FSTheme.colors.brown),
        decorationBox = {
            Box(
                modifier = Modifier
                    .conditional(onClick != null) {
                        noRippleClickable { onClick?.invoke() }
                    }
                    .padding(horizontal = 20.dp, vertical = 16.dp),
                contentAlignment = Alignment.CenterStart,
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Box(
                        modifier = Modifier.weight(1f),
                        contentAlignment = Alignment.CenterStart,
                    ) {
                        if (value.isBlank() && label != null) {
                            FSText(
                                text = label,
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Normal,
                                    color = FSTheme.colors.brown,
                                ),
                                color = FSTheme.colors.brown.copy(alpha = 0.5f)
                            )
                        } else {
                            it()
                        }
                    }
                    trailingIcon?.let { trailingIcon ->
                        trailingIcon()
                    }
                }
            }
        },
        visualTransformation = if (isPassword) visualTransformation else VisualTransformation.None,
    )
}

@Preview(showBackground = true)
@Composable
private fun FSTextFieldPreview() {
    FSTheme {
        Box(
            modifier = Modifier.padding(16.dp),
        ) {
            FSTextField(
                value = "caner@gmail.com",
                label = "Your Email",
                isPassword = true,
                onValueChange = {},
            )
        }
    }
}