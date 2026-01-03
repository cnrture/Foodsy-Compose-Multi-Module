package com.canerture.hogwartia.feature.splash

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
import com.canerture.hogwartia.ui.components.HWIcon
import com.canerture.hogwartia.ui.components.HWSpacer
import com.canerture.hogwartia.ui.components.HWText
import com.canerture.hogwartia.ui.extensions.collectWithLifecycle
import com.canerture.hogwartia.ui.theme.HWTheme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun SplashScreen(
    uiEffect: Flow<UiEffect>,
) {
    uiEffect.collectWithLifecycle {}

    SplashContent(
        modifier = Modifier.fillMaxSize(),
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
        HWIcon(
            modifier = Modifier.size(170.dp),
            vector = HWTheme.icons.logo,
        )
        HWSpacer(12)
        HWText(
            text = "Hogwartia",
            style = TextStyle(
                fontSize = 48.sp,
                fontWeight = FontWeight.Medium,
            )
        )
        HWSpacer(4)
        HWText(
            text = "Food Delivery App",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
internal fun SplashScreenPreview() {
    HWTheme {
        SplashScreen(
            uiEffect = emptyFlow(),
        )
    }
}