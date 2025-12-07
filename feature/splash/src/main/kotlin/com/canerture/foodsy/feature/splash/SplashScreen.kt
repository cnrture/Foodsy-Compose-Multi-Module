package com.canerture.foodsy.feature.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.canerture.foodsy.feature.splash.SplashContract.UiEffect
import com.canerture.ui.extensions.collectWithLifecycle
import com.canerture.ui.theme.FSTheme
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
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            imageVector = FSTheme.icons.logo,
            contentDescription = "Foodsy Logo",
        )
        Text(
            text = "Splash Content",
            fontSize = 24.sp,
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