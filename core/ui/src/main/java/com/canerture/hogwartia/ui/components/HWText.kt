package com.canerture.hogwartia.ui.components

import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
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
import com.canerture.hogwartia.ui.R

@Composable
fun HWText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onBackground,
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
                Font(R.font.noto_regular, FontWeight.Normal),
                Font(R.font.noto_semibold, FontWeight.SemiBold),
                Font(R.font.noto_bold, FontWeight.Bold),
            ),
        ),
        overflow = overflow,
        maxLines = maxLines,
    )
}

@Composable
fun HWText(
    modifier: Modifier = Modifier,
    fullText: String,
    spanText: String,
    color: Color = MaterialTheme.colorScheme.onBackground,
    style: TextStyle = LocalTextStyle.current,
    spanStyle: SpanStyle = SpanStyle(),
    textAlign: TextAlign? = null,
) {
    Text(
        text = buildAnnotatedString {
            withStyle(style = style.toSpanStyle()) {
                append(fullText)
                val mStartIndex = fullText.indexOf(spanText)
                val mEndIndex = mStartIndex.plus(spanText.length)
                addStyle(
                    style = spanStyle,
                    start = mStartIndex,
                    end = mEndIndex,
                )
            }
        },
        modifier = modifier,
        textAlign = textAlign,
        style = style.merge(
            color = color,
            fontFamily = FontFamily(
                Font(R.font.noto_regular, FontWeight.Normal),
                Font(R.font.noto_semibold, FontWeight.SemiBold),
                Font(R.font.noto_bold, FontWeight.Bold),
            ),
        ),
    )
}

@Preview(showBackground = true)
@Composable
private fun HWTextPreview() {
    HWText(
        text = "HWText"
    )
}