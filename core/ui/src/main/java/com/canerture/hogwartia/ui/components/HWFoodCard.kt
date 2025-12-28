package com.canerture.hogwartia.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.canerture.hogwartia.ui.extensions.noRippleClickable
import com.canerture.hogwartia.ui.theme.HWTheme

@Composable
fun HWFoodCard(
    modifier: Modifier = Modifier,
    title: String,
    icon: ImageVector,
    price: String,
    isFavorite: Boolean = false,
    onFavoriteClick: () -> Unit = {},
    onAddClick: () -> Unit = {},
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(32.dp),
        colors = CardDefaults.cardColors(
            containerColor = HWTheme.colors.softPink,
        ),
        elevation = CardDefaults.cardElevation(0.dp),
    ) {
        Box {
            Column(
                modifier = Modifier.padding(24.dp),
            ) {
                HWIcon(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f),
                    vector = icon,
                )

                HWSpacer(24)

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Column {
                        HWText(
                            text = title,
                            style = TextStyle(
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                            ),
                            color = HWTheme.colors.brown,
                        )

                        HWSpacer(4)

                        HWText(
                            text = price,
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.SemiBold,
                            ),
                            color = HWTheme.colors.darkBrown,
                        )
                    }

                    Box(
                        modifier = Modifier
                            .size(44.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .border(
                                width = 1.dp,
                                color = HWTheme.colors.lightBrown,
                                shape = RoundedCornerShape(12.dp),
                            )
                            .noRippleClickable { onAddClick() },
                        contentAlignment = Alignment.Center,
                    ) {
                        HWIcon(
                            modifier = Modifier.size(14.dp),
                            vector = HWTheme.icons.plus,
                            tint = HWTheme.colors.brown,
                        )
                    }
                }
            }

            HWIcon(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(24.dp),
                vector = if (isFavorite) HWTheme.icons.favoriteFilled else HWTheme.icons.favoriteOutline,
                tint = HWTheme.colors.orange,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HWFoodCardPreview() {
    HWFoodCard(
        title = "Specials Sushi",
        price = "$38.00",
        isFavorite = true,
        icon = HWTheme.icons.logo,
    )
}