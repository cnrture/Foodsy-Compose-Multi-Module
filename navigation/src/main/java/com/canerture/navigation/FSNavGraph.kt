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
import com.canerture.hogwartia.feature.login.navigation.LoginRoute
import com.canerture.hogwartia.feature.onboarding.navigation.OnboardingRoute
import com.canerture.hogwartia.feature.register.navigation.RegisterRoute
import com.canerture.hogwartia.feature.splash.navigation.SplashRoute
import com.canerture.hogwartia.ui.delegate.navigator.RememberBackStack
import com.canerture.hogwartia.ui.navigation.Screen
import com.cnrture.hogwartia.feature.welcome.navigation.WelcomeRoute
import com.cnrture.hogwartia.feature.characters.navigation.CategoriesRoute
import com.cnrture.hogwartia.feature.characterdetail.navigation.ConfirmOrderRoute
import com.cnrture.hogwartia.feature.discount.navigation.DiscountRoute
import com.cnrture.hogwartia.feature.dishdetail.navigation.DishDetailRoute
import com.cnrture.hogwartia.feature.favorites.navigation.FavoritesRoute
import com.cnrture.hogwartia.feature.ordercomplete.navigation.OrderCompleteRoute
import com.cnrture.hogwartia.feature.orders.navigation.OrdersRoute
import com.cnrture.hogwartia.feature.profile.navigation.ProfileRoute
import com.cnrture.hogwartia.feature.search.navigation.SearchRoute
import com.cnrture.hogwartia.forgotpassword.navigation.ForgotPasswordRoute
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
                    subclass(Screen.Orders::class, Screen.Orders.serializer())
                    subclass(Screen.Profile::class, Screen.Profile.serializer())
                    subclass(Screen.Search::class, Screen.Search.serializer())
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
                entry<Screen.Cart> { WelcomeRoute() }
                entry<Screen.Categories> { CategoriesRoute() }
                entry<Screen.ConfirmOrder> { ConfirmOrderRoute() }
                entry<Screen.Discount> { DiscountRoute() }
                entry<Screen.DishDetail> { DishDetailRoute() }
                entry<Screen.Favorites> { FavoritesRoute() }
                entry<Screen.ForgotPassword> { ForgotPasswordRoute() }
                entry<Screen.OrderComplete> { OrderCompleteRoute() }
                entry<Screen.Orders> { OrdersRoute() }
                entry<Screen.Profile> { ProfileRoute() }
                entry<Screen.Search> { SearchRoute() }
            }
        )
    }
}