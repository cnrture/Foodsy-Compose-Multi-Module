package com.canerture.foodsy.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.canerture.navigation.FSNavGraph
import com.canerture.navigation.NavigationItem
import com.canerture.ui.theme.FSTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val visibleBottomSheetScreen = NavigationItem.getNavigationRoutes()

            FSTheme {
                Box {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        containerColor = FSTheme.colors.lightYellow,
                        content = { innerPadding ->
                            FSNavGraph(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(innerPadding),
                            )
                        },
                        bottomBar = {
                        }
                    )
                }
            }
        }
    }
}