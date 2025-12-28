package com.canerture.hogwartia.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.canerture.hogwartia.ui.R

internal val LocalIcons = staticCompositionLocalOf { HWIcons() }

class HWIcons {
    val logo: ImageVector
        @Composable
        get() = ImageVector.vectorResource(id = R.drawable.ic_logo)

    val arrowBack: ImageVector
        @Composable
        get() = ImageVector.vectorResource(id = R.drawable.ic_arrow_back)

    val cartFilled: ImageVector
        @Composable
        get() = ImageVector.vectorResource(id = R.drawable.ic_cart_filled)

    val cartOutline: ImageVector
        @Composable
        get() = ImageVector.vectorResource(id = R.drawable.ic_cart_outline)

    val categoriesFilled: ImageVector
        @Composable
        get() = ImageVector.vectorResource(id = R.drawable.ic_categories_filled)

    val categoriesOutline: ImageVector
        @Composable
        get() = ImageVector.vectorResource(id = R.drawable.ic_categories_outline)

    val delete: ImageVector
        @Composable
        get() = ImageVector.vectorResource(id = R.drawable.ic_delete)

    val discountFilled: ImageVector
        @Composable
        get() = ImageVector.vectorResource(id = R.drawable.ic_discount_filled)

    val discountOutline: ImageVector
        @Composable
        get() = ImageVector.vectorResource(id = R.drawable.ic_discount_outline)

    val favoriteFilled: ImageVector
        @Composable
        get() = ImageVector.vectorResource(id = R.drawable.ic_fav_filled)

    val favoriteOutline: ImageVector
        @Composable
        get() = ImageVector.vectorResource(id = R.drawable.ic_fav_outline)

    val google: ImageVector
        @Composable
        get() = ImageVector.vectorResource(id = R.drawable.ic_google)

    val homeFilled: ImageVector
        @Composable
        get() = ImageVector.vectorResource(id = R.drawable.ic_home_filled)

    val homeOutline: ImageVector
        @Composable
        get() = ImageVector.vectorResource(id = R.drawable.ic_home_outline)

    val minus: ImageVector
        @Composable
        get() = ImageVector.vectorResource(id = R.drawable.ic_minus)

    val plus: ImageVector
        @Composable
        get() = ImageVector.vectorResource(id = R.drawable.ic_plus)

    val search: ImageVector
        @Composable
        get() = ImageVector.vectorResource(id = R.drawable.ic_search)

    val filter: ImageVector
        @Composable
        get() = ImageVector.vectorResource(id = R.drawable.ic_filter)

    val visibilityOn: ImageVector
        @Composable
        get() = ImageVector.vectorResource(id = R.drawable.ic_visibility_on)

    val visibilityOff: ImageVector
        @Composable
        get() = ImageVector.vectorResource(id = R.drawable.ic_visibility_off)
}