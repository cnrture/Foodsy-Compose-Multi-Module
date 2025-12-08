package com.canerture.foodsy.feature.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.canerture.foodsy.feature.onboarding.OnboardingContract.UiAction
import com.canerture.foodsy.feature.onboarding.OnboardingContract.UiEffect
import com.canerture.foodsy.feature.onboarding.OnboardingContract.UiState
import com.canerture.ui.components.FSSpacer
import com.canerture.ui.components.FSText
import com.canerture.ui.extensions.collectWithLifecycle
import com.canerture.ui.theme.FSTheme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun OnboardingScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
) {
    uiEffect.collectWithLifecycle {}

    OnboardingContent(
        modifier = Modifier.fillMaxSize(),
        uiState = uiState,
        onAction = onAction,
    )
}

@Composable
fun OnboardingContent(
    modifier: Modifier = Modifier,
    uiState: UiState,
    onAction: (UiAction) -> Unit,
) {
    val onboardingPages = getOnboardingData()

    val pagerState = rememberPagerState(initialPage = 0, initialPageOffsetFraction = 0f) { onboardingPages.size }
    val scope = rememberCoroutineScope()

    HorizontalPager(
        modifier = Modifier.fillMaxWidth(),
        pageSize = PageSize.Fill,
        state = pagerState
    ) { page ->
        PageContent(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            data = onboardingPages[page],
        )
    }
}

@Composable
fun PageContent(
    modifier: Modifier = Modifier,
    data: OnboardingData,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            imageVector = data.image,
            contentDescription = null,
        )
        FSSpacer(64)
        FSText(
            fullText = data.title,
            spanText = data.titleSpan,
            style = TextStyle(
                fontSize = 36.sp,
                fontWeight = FontWeight.Normal,
            ),
            spanStyle = SpanStyle(
                fontWeight = FontWeight.Bold,
            ),
        )
    }
}

@Composable
private fun getOnboardingData() = listOf(
    OnboardingData(
        title = "Diverse and fresh food",
        titleSpan = "and fresh food",
        description = "With an extensive menu prepared by talented chefs, fresh quality food.",
        image = FSTheme.icons.onboardingOne,
    ),
    OnboardingData(
        title = "Easy to change dish ingredients",
        titleSpan = "change dish ingredients",
        description = "You are a foodie, you can add or subtract ingredients in the dish.",
        image = FSTheme.icons.onboardingTwo,
    ),
    OnboardingData(
        title = "Delivery is given on time",
        titleSpan = "is given on time",
        description = "With an extensive menu prepared by talented chefs, fresh quality food.",
        image = FSTheme.icons.onboardingThree,
    ),
)

@Preview(showBackground = true)
@Composable
fun OnboardingScreenPreview(
    @PreviewParameter(OnboardingScreenPreviewProvider::class) uiState: UiState,
) {
    OnboardingScreen(
        uiState = uiState,
        uiEffect = emptyFlow(),
        onAction = {},
    )
}