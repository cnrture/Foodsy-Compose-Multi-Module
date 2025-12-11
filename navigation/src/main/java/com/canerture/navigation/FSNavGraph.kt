package com.canerture.navigation

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
import com.canerture.home.feature.home.navigation.HomeRoute
import com.canerture.ui.delegate.navigator.RememberBackStack
import com.canerture.ui.navigation.Screen
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

@Composable
fun FSNavGraph(
    modifier: Modifier = Modifier,
) {
    val backStack = rememberNavBackStack(
        configuration = SavedStateConfiguration {
            serializersModule = SerializersModule {
                polymorphic(NavKey::class) {
                    subclass(Screen.Splash::class, Screen.Splash.serializer())
                    subclass(Screen.Onboarding::class, Screen.Onboarding.serializer())
                    subclass(Screen.Login::class, Screen.Login.serializer())
                    subclass(Screen.Register::class, Screen.Register.serializer())
                }
            }
        },
        Screen.Splash
    )

    RememberBackStack(backStack) {
        NavDisplay(
            modifier = modifier,
            backStack = backStack,
            onBack = { backStack.removeLastOrNull() },
            entryDecorators = listOf(
                rememberSaveableStateHolderNavEntryDecorator(),
                rememberViewModelStoreNavEntryDecorator(),
            ),
            entryProvider = entryProvider {
                entry<Screen.Splash> {
                    SplashRoute(
                        onNavigateOnboarding = {
                            backStack.remove(Screen.Splash)
                            backStack.add(Screen.Onboarding)
                        },
                        onNavigateLogin = {
                            backStack.remove(Screen.Splash)
                            backStack.add(Screen.Login)
                        },
                    )
                }
                entry<Screen.Onboarding> { OnboardingRoute() }
                entry<Screen.Login> { LoginRoute() }
                entry<Screen.Register> { RegisterRoute() }
                entry<Screen.Home> { HomeRoute() }
            }
        )
    }
}