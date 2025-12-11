package com.canerture.ui.delegate.navigator

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey

@Composable
fun RememberBackStack(
    backStack: NavBackStack<NavKey>,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(LocalBackStack provides backStack, content)
}

val LocalBackStack = staticCompositionLocalOf<NavBackStack<NavKey>> {
    error("CompositionLocal LocalBackStack not present")
}