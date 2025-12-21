package com.canerture.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import com.canerture.foodsy.feature.login.navigation.LoginRoute
import com.canerture.foodsy.feature.onboarding.navigation.OnboardingRoute
import com.canerture.foodsy.feature.register.navigation.RegisterRoute
import com.canerture.foodsy.feature.splash.navigation.SplashRoute
import com.canerture.ui.delegate.navigator.RememberBackStack
import com.canerture.ui.navigation.Screen
import com.cnrture.foodsy.feature.cart.navigation.CartRoute
import com.cnrture.foodsy.feature.categories.navigation.CategoriesRoute
import com.cnrture.foodsy.feature.confirmorder.navigation.ConfirmOrderRoute
import com.cnrture.foodsy.feature.discount.navigation.DiscountRoute
import com.cnrture.foodsy.feature.dishdetail.navigation.DishDetailRoute
import com.cnrture.foodsy.feature.favorites.navigation.FavoritesRoute
import com.cnrture.foodsy.feature.ordercomplete.navigation.OrderCompleteRoute
import com.cnrture.foodsy.forgotpassword.navigation.ForgotPasswordRoute
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

@Composable
fun FSNavGraph() {
    val backStack = rememberNavBackStack(
        configuration = SavedStateConfiguration {
            serializersModule = SerializersModule {
                polymorphic(NavKey::class) {
                    subclass(Screen.Splash::class, Screen.Splash.serializer())
                    subclass(Screen.Onboarding::class, Screen.Onboarding.serializer())
                    subclass(Screen.Login::class, Screen.Login.serializer())
                    subclass(Screen.Register::class, Screen.Register.serializer())
                    subclass(Screen.BottomBar::class, Screen.BottomBar.serializer())
                    subclass(Screen.Cart::class, Screen.Cart.serializer())
                    subclass(Screen.Categories::class, Screen.Categories.serializer())
                    subclass(Screen.ConfirmOrder::class, Screen.ConfirmOrder.serializer())
                    subclass(Screen.Discount::class, Screen.Discount.serializer())
                    subclass(Screen.DishDetail::class, Screen.DishDetail.serializer())
                    subclass(Screen.Favorites::class, Screen.Favorites.serializer())
                    subclass(Screen.ForgotPassword::class, Screen.ForgotPassword.serializer())
                    subclass(Screen.OrderComplete::class, Screen.OrderComplete.serializer())
                }
            }
        },
        Screen.BottomBar
    )

    RememberBackStack(backStack) {
        NavDisplay(
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding(),
            backStack = backStack,
            onBack = { backStack.removeLastOrNull() },
            entryDecorators = listOf(
                rememberSaveableStateHolderNavEntryDecorator(),
                rememberViewModelStoreNavEntryDecorator(),
            ),
            entryProvider = entryProvider {
                entry<Screen.Splash> { SplashRoute() }
                entry<Screen.Onboarding> { OnboardingRoute() }
                entry<Screen.Login> { LoginRoute() }
                entry<Screen.Register> { RegisterRoute() }
                entry<Screen.BottomBar> { FSBottomBar() }
                entry<Screen.Cart> { CartRoute() }
                entry<Screen.Categories> { CategoriesRoute() }
                entry<Screen.ConfirmOrder> { ConfirmOrderRoute() }
                entry<Screen.Discount> { DiscountRoute() }
                entry<Screen.DishDetail> { DishDetailRoute() }
                entry<Screen.Favorites> { FavoritesRoute() }
                entry<Screen.ForgotPassword> { ForgotPasswordRoute() }
                entry<Screen.OrderComplete> { OrderCompleteRoute() }
            }
        )
    }
}