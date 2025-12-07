package com.canerture.ui.components

import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.canerture.core.ui.R
import com.canerture.ui.theme.FSTheme

@Composable
fun FSText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = FSTheme.colors.brown,
    style: TextStyle = LocalTextStyle.current,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign? = null,
) {
    Text(
        text = text,
        modifier = modifier,
        textAlign = textAlign,
        style = style.merge(
            color = color,
            fontFamily = FontFamily(
                Font(R.font.poppins_regular, FontWeight.Normal),
                Font(R.font.poppins_medium, FontWeight.Medium),
                Font(R.font.poppins_semi_bold, FontWeight.SemiBold),
                Font(R.font.poppins_bold, FontWeight.Bold),
            ),
        ),
        overflow = overflow,
        maxLines = maxLines
    )
}

@Composable
fun FSText(
    modifier: Modifier = Modifier,
    fullText: String,
    spanTexts: List<String>,
    style: TextStyle = LocalTextStyle.current,
    spanStyle: SpanStyle = SpanStyle(),
    textAlign: TextAlign? = null,
) {
    Text(
        text = buildAnnotatedString {
            withStyle(style = style.toSpanStyle()) {
                append(fullText)
                spanTexts.forEach {
                    val mStartIndex = fullText.indexOf(it)
                    val mEndIndex = mStartIndex.plus(it.length)
                    addStyle(
                        style = spanStyle,
                        start = mStartIndex,
                        end = mEndIndex,
                    )
                }
            }
        },
        modifier = modifier,
        textAlign = textAlign,
        style = style
    )
}

@Preview(showBackground = true)
@Composable
private fun FSTextPreview() {
    FSText(
        text = "FSText"
    )
}