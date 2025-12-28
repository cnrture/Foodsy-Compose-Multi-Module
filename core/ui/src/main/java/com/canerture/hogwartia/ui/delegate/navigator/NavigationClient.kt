package com.canerture.hogwartia.ui.delegate.navigator

import com.canerture.hogwartia.ui.navigation.Screen
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow

interface NavigationClient {
    val navigationClientEffect: Flow<NavigationClientEffect>
    suspend fun navigateTo(route: Screen, popup: Screen? = null)
    suspend fun navigateBack()
}

class NavigationClientImpl internal constructor() : NavigationClient {

    private val _navigationClientEffect = Channel<NavigationClientEffect>()
    override val navigationClientEffect: Flow<NavigationClientEffect> = _navigationClientEffect.receiveAsFlow()

    override suspend fun navigateTo(route: Screen, popup: Screen?) {
        emitEffect(NavigationClientEffect.NavigateTo(route, popup))
    }

    override suspend fun navigateBack() {
        emitEffect(NavigationClientEffect.NavigateBack)
    }

    private suspend fun emitEffect(effect: NavigationClientEffect) {
        _navigationClientEffect.send(effect)
    }
}

fun navigationClient(): NavigationClient = NavigationClientImpl()