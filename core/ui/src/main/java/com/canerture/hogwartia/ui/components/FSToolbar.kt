package com.canerture.hogwartia.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.canerture.hogwartia.ui.theme.FSTheme

@Composable
fun FSToolbar(
    title: String,
    titleSpan: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        verticalAlignment = Alignment.Top,
    ) {
        FSText(
            modifier = Modifier.weight(1f),
            fullText = title,
            spanText = titleSpan,
            style = TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.Normal,
                color = FSTheme.colors.brown,
            ),
            spanStyle = SpanStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = FSTheme.colors.brown,
            )
        )
        Box(
            modifier = Modifier
                .size(46.dp)
                .background(
                    color = FSTheme.colors.softPink,
                    shape = RoundedCornerShape(16.dp),
                ),
            contentAlignment = Alignment.Center,
        ) {
            FSIcon(
                vector = FSTheme.icons.logo,
                contentDescription = "HouseDetail Icon"
            )
        }
    }
}

@Composable
fun FSToolbar(
    onBackClick: () -> Unit,
    endContent: @Composable () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        verticalAlignment = Alignment.Top,
    ) {
        FSIcon(
            modifier = Modifier.clickable { onBackClick() },
            vector = FSTheme.icons.arrowBack,
            contentDescription = "Back Icon",
        )
        Spacer(modifier = Modifier.weight(1f))
        endContent()
    }
}

@Preview(showBackground = true)
@Composable
private fun FSToolbarPreview() {
    Column {
        Spacer(modifier = Modifier.height(12.dp))
        FSToolbar(
            title = "Specials\nMenu Offers",
            titleSpan = "Menu Offers",
        )
        Spacer(modifier = Modifier.height(12.dp))
        FSToolbar(
            onBackClick = { },
            endContent = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    FSIcon(
                        vector = FSTheme.icons.search,
                        contentDescription = "HouseDetail Icon",
                    )
                    FSSpacer(24)
                    FSIcon(
                        vector = FSTheme.icons.filter,
                        contentDescription = "Filter Icon",
                    )
                }
            },
        )
    }
}