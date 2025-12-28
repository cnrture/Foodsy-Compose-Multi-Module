package com.canerture.hogwartia.feature.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.canerture.hogwartia.feature.onboarding.OnboardingContract.UiAction
import com.canerture.hogwartia.feature.onboarding.OnboardingContract.UiEffect
import com.canerture.ui.components.FSButton
import com.canerture.ui.components.FSButtonType
import com.canerture.ui.components.FSSpacer
import com.canerture.ui.components.FSText
import com.canerture.ui.extensions.collectWithLifecycle
import com.canerture.ui.theme.FSTheme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun OnboardingScreen(
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
) {
    uiEffect.collectWithLifecycle {}

    OnboardingContent(
        modifier = Modifier
            .fillMaxSize()
            .background(FSTheme.colors.lightYellow)
            .padding(vertical = 36.dp),
        onAction = onAction,
    )
}

@Composable
fun OnboardingContent(
    modifier: Modifier = Modifier,
    onAction: (UiAction) -> Unit,
) {
    val onboardingPages = getOnboardingData()
    val pagerState = rememberPagerState(initialPage = 0, initialPageOffsetFraction = 0f) { onboardingPages.size }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        HorizontalPager(
            state = pagerState,
            pageSize = PageSize.Fill,
            contentPadding = PaddingValues(36.dp),
            pageSpacing = 44.dp,
        ) {
            PageContent(data = onboardingPages[it])
        }
        FSSpacer(32)
        Indicators(
            size = 3,
            index = pagerState.currentPage,
        )
        Spacer(Modifier.weight(1f))
        FSButton(
            text = stringResource(id = R.string.skip),
            type = FSButtonType.OUTLINED,
            onClick = { onAction(UiAction.OnSkipClick) },
        )
    }
}

@Composable
private fun PageContent(
    data: OnboardingData,
) {
    Column {
        Image(
            modifier = Modifier.aspectRatio(1f),
            painter = painterResource(id = data.image),
            contentDescription = null,
        )
        FSSpacer(64)
        FSText(
            fullText = stringResource(id = data.title),
            spanText = stringResource(id = data.titleSpan),
            style = TextStyle(
                fontSize = 36.sp,
                fontWeight = FontWeight.Normal,
            ),
            spanStyle = SpanStyle(
                fontWeight = FontWeight.Bold,
            ),
            textAlign = TextAlign.Center,
        )
        FSSpacer(16)
        FSText(
            text = stringResource(id = data.description),
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
            ),
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
private fun Indicators(modifier: Modifier = Modifier, size: Int, index: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
    ) {
        repeat(size) {
            Box(
                modifier = Modifier
                    .height(5.dp)
                    .width(if (it == index) 22.dp else 5.dp)
                    .clip(shape = CircleShape)
                    .background(
                        if (it == index) FSTheme.colors.green else FSTheme.colors.green.copy(0.5f)
                    )
            )
        }
    }
}

@Composable
private fun getOnboardingData() = listOf(
    OnboardingData(
        title = R.string.onboarding_one_title,
        titleSpan = R.string.onboarding_one_title_span,
        description = R.string.onboarding_one_description,
        image = R.drawable.ic_onboarding_one,
    ),
    OnboardingData(
        title = R.string.onboarding_two_title,
        titleSpan = R.string.onboarding_two_title_span,
        description = R.string.onboarding_two_description,
        image = R.drawable.ic_onboarding_two,
    ),
    OnboardingData(
        title = R.string.onboarding_three_title,
        titleSpan = R.string.onboarding_three_title_span,
        description = R.string.onboarding_three_description,
        image = R.drawable.ic_onboarding_three,
    ),
)

@Preview(showBackground = true)
@Composable
fun OnboardingScreenPreview() {
    FSTheme {
        OnboardingScreen(
            uiEffect = emptyFlow(),
            onAction = {},
        )
    }
}