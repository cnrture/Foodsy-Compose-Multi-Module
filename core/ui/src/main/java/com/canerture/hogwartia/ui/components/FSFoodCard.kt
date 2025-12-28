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
import com.canerture.hogwartia.ui.theme.FSTheme

@Composable
fun FSFoodCard(
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
            containerColor = FSTheme.colors.softPink,
        ),
        elevation = CardDefaults.cardElevation(0.dp),
    ) {
        Box {
            Column(
                modifier = Modifier.padding(24.dp),
            ) {
                FSIcon(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f),
                    vector = icon,
                )

                FSSpacer(24)

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Column {
                        FSText(
                            text = title,
                            style = TextStyle(
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                            ),
                            color = FSTheme.colors.brown,
                        )

                        FSSpacer(4)

                        FSText(
                            text = price,
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.SemiBold,
                            ),
                            color = FSTheme.colors.darkBrown,
                        )
                    }

                    Box(
                        modifier = Modifier
                            .size(44.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .border(
                                width = 1.dp,
                                color = FSTheme.colors.lightBrown,
                                shape = RoundedCornerShape(12.dp),
                            )
                            .noRippleClickable { onAddClick() },
                        contentAlignment = Alignment.Center,
                    ) {
                        FSIcon(
                            modifier = Modifier.size(14.dp),
                            vector = FSTheme.icons.plus,
                            tint = FSTheme.colors.brown,
                        )
                    }
                }
            }

            FSIcon(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(24.dp),
                vector = if (isFavorite) FSTheme.icons.favoriteFilled else FSTheme.icons.favoriteOutline,
                tint = FSTheme.colors.orange,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FSFoodCardPreview() {
    FSFoodCard(
        title = "Specials Sushi",
        price = "$38.00",
        isFavorite = true,
        icon = FSTheme.icons.logo,
    )
}