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
import com.cnrture.hogwartia.feature.characterdetail.navigation.CharacterDetailRoute
import com.cnrture.hogwartia.feature.characters.navigation.CharactersRoute
import com.cnrture.hogwartia.feature.discount.navigation.DiscountRoute
import com.cnrture.hogwartia.feature.dishdetail.navigation.DishDetailRoute
import com.cnrture.hogwartia.feature.favorites.navigation.FavoritesRoute
import com.cnrture.hogwartia.feature.ordercomplete.navigation.MovieDetailRoute
import com.cnrture.hogwartia.feature.orders.navigation.SpellsRoute
import com.cnrture.hogwartia.feature.profile.navigation.ProfileRoute
import com.cnrture.hogwartia.feature.search.navigation.SearchRoute
import com.cnrture.hogwartia.feature.welcome.navigation.WelcomeRoute
import com.cnrture.hogwartia.movies.navigation.MoviesRoute
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
                    subclass(Screen.Welcome::class, Screen.Welcome.serializer())
                    subclass(Screen.Characters::class, Screen.Characters.serializer())
                    subclass(Screen.CharacterDetail::class, Screen.CharacterDetail.serializer())
                    subclass(Screen.Discount::class, Screen.Discount.serializer())
                    subclass(Screen.DishDetail::class, Screen.DishDetail.serializer())
                    subclass(Screen.Favorites::class, Screen.Favorites.serializer())
                    subclass(Screen.Movies::class, Screen.Movies.serializer())
                    subclass(Screen.MovieDetail::class, Screen.MovieDetail.serializer())
                    subclass(Screen.Spells::class, Screen.Spells.serializer())
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
                entry<Screen.Welcome> { WelcomeRoute() }
                entry<Screen.Characters> { CharactersRoute() }
                entry<Screen.CharacterDetail> { CharacterDetailRoute() }
                entry<Screen.Discount> { DiscountRoute() }
                entry<Screen.DishDetail> { DishDetailRoute() }
                entry<Screen.Favorites> { FavoritesRoute() }
                entry<Screen.Movies> { MoviesRoute() }
                entry<Screen.MovieDetail> { MovieDetailRoute() }
                entry<Screen.Spells> { SpellsRoute() }
                entry<Screen.Profile> { ProfileRoute() }
                entry<Screen.Search> { SearchRoute() }
            }
        )
    }
}