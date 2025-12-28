package com.canerture.home.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.canerture.hogwartia.feature.home.R
import com.canerture.hogwartia.ui.components.HWFoodCard
import com.canerture.hogwartia.ui.components.HWIcon
import com.canerture.hogwartia.ui.components.HWLoading
import com.canerture.hogwartia.ui.components.HWSpacer
import com.canerture.hogwartia.ui.components.HWText
import com.canerture.hogwartia.ui.components.HWToolbar
import com.canerture.hogwartia.ui.extensions.collectWithLifecycle
import com.canerture.hogwartia.ui.theme.HWTheme
import com.canerture.home.feature.home.HomeContract.UiAction
import com.canerture.home.feature.home.HomeContract.UiEffect
import com.canerture.home.feature.home.HomeContract.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun HomeScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
) {
    uiEffect.collectWithLifecycle {}

    Scaffold(
        topBar = {
            HWToolbar(
                title = stringResource(R.string.title),
                titleSpan = stringResource(R.string.title_span),
            )
        },
        containerColor = HWTheme.colors.lightYellow,
    ) { paddingValues ->
        HomeContent(
            modifier = Modifier
                .fillMaxSize()
                .background(HWTheme.colors.lightYellow)
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(vertical = 24.dp),
            uiState = uiState,
            onAction = onAction,
        )

        if (uiState.isLoading) HWLoading()
    }
}

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    uiState: UiState,
    onAction: (UiAction) -> Unit,
) {
    val pagerState = rememberPagerState(initialPage = 1, initialPageOffsetFraction = 0f) { 5 }

    Column(
        modifier = modifier,
    ) {
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 36.dp)
        ) {
            items(6) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    HWIcon(
                        modifier = Modifier.size(46.dp),
                        vector = HWTheme.icons.logo,
                    )
                    HWSpacer(8)
                    HWText(
                        text = "Sushi",
                        style = TextStyle(fontWeight = FontWeight.Bold),
                    )
                }
                HWSpacer(24)
            }
        }

        HWSpacer(32)

        HorizontalPager(
            state = pagerState,
            pageSize = PageSize.Fill,
            contentPadding = PaddingValues(horizontal = 48.dp),
            pageSpacing = 20.dp,
        ) {
            HWFoodCard(
                title = "Specials Sushi",
                price = "$${38 + it * 2}.00",
                icon = HWTheme.icons.logo,
                isFavorite = it == 1,
                onFavoriteClick = {},
                onAddClick = {},
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(
    @PreviewParameter(HomeScreenPreviewProvider::class) uiState: UiState,
) {
    HomeScreen(
        uiState = uiState,
        uiEffect = emptyFlow(),
        onAction = {},
    )
}