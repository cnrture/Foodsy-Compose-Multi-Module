package com.canerture.ui.delegate.navigator

import androidx.compose.runtime.Composable
import com.canerture.ui.extensions.collectWithLifecycle
import kotlinx.coroutines.flow.Flow

@Composable
fun NavigationClientCollector(navigationEffect: Flow<NavigationClientEffect>) {
    val backStack = LocalBackStack.current
    navigationEffect.collectWithLifecycle { effect ->
        when (effect) {
            is NavigationClientEffect.NavigateTo -> {
                effect.popup?.let { backStack.remove(it) }
                backStack.add(effect.route)
            }

            is NavigationClientEffect.NavigateBack -> backStack.removeLastOrNull()
        }
    }
}