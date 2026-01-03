package com.canerture.hogwartia.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.canerture.hogwartia.ui.R

val Noto = FontFamily(
    Font(R.font.noto_regular, FontWeight.Normal),
    Font(R.font.noto_semibold, FontWeight.SemiBold),
    Font(R.font.noto_bold, FontWeight.Bold),
)

val HWTypography: Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = Noto,
        fontWeight = FontWeight.Normal,
        fontSize = 17.sp,
        lineHeight = 24.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = Noto,
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp,
        lineHeight = 20.sp
    ),
    bodySmall = TextStyle(
        fontFamily = Noto,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        lineHeight = 20.sp
    ),
    titleLarge = TextStyle(
        fontFamily = Noto,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        lineHeight = 36.sp
    ),
    titleSmall = TextStyle(
        fontFamily = Noto,
        fontWeight = FontWeight.Medium,
        fontSize = 17.sp,
        lineHeight = 24.sp
    ),
)