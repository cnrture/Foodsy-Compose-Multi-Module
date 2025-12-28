package com.canerture.hogwartia.feature.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.canerture.hogwartia.feature.splash.SplashContract.UiEffect
import com.canerture.hogwartia.ui.components.FSIcon
import com.canerture.hogwartia.ui.components.FSSpacer
import com.canerture.hogwartia.ui.components.FSText
import com.canerture.hogwartia.ui.extensions.collectWithLifecycle
import com.canerture.hogwartia.ui.theme.FSTheme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun SplashScreen(
    uiEffect: Flow<UiEffect>,
) {
    uiEffect.collectWithLifecycle {}

    SplashContent(
        modifier = Modifier
            .fillMaxSize()
            .background(FSTheme.colors.lightYellow),
    )
}

@Composable
internal fun SplashContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        FSIcon(
            modifier = Modifier.size(170.dp),
            vector = FSTheme.icons.logo,
        )
        FSSpacer(12)
        FSText(
            text = "Hogwartia",
            style = TextStyle(
                fontSize = 48.sp,
                fontWeight = FontWeight.Medium,
            )
        )
        FSSpacer(4)
        FSText(
            text = "Food Delivery App",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            ),
            color = FSTheme.colors.orange,
        )
    }
}

@Preview(showBackground = true)
@Composable
internal fun SplashScreenPreview() {
    FSTheme {
        SplashScreen(
            uiEffect = emptyFlow(),
        )
    }
}