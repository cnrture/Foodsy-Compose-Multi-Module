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
import com.canerture.foodsy.feature.onboarding.navigation.OnboardingRoute
import com.canerture.foodsy.feature.splash.navigation.SplashRoute
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
                    subclass(SplashRoute::class, SplashRoute.serializer())
                    subclass(OnboardingRoute::class, OnboardingRoute.serializer())
                }
            }
        },
        SplashRoute
    )
    NavDisplay(
        modifier = modifier,
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator(),
        ),
        entryProvider = entryProvider {
            entry<SplashRoute> {
                SplashRoute(
                    onNavigateOnboarding = {
                        backStack.remove(SplashRoute)
                        backStack.add(OnboardingRoute)
                    },
                    onNavigateLogin = { /* TODO: Navigate to Login */ }
                )
            }
            entry<OnboardingRoute> { OnboardingRoute() }
        }
    )
}