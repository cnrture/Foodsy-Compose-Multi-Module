package com.canerture.foodsy.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.canerture.navigation.FSBottomBar
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
            val navController = rememberNavController()

            val visibleBottomSheetScreen = NavigationItem.getNavigationRoutes()

            val bottomBarVisibility =
                navController.currentBackStackEntryAsState().value?.destination?.route in visibleBottomSheetScreen

            FSTheme {
                Box {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        containerColor = FSTheme.colors.brown,
                        content = { innerPadding ->
                            FSNavGraph(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(innerPadding),
                                navController = navController,
                            )
                        },
                        bottomBar = {
                            AnimatedVisibility(bottomBarVisibility) {
                                Column {
                                    HorizontalDivider(
                                        thickness = 2.dp,
                                        color = FSTheme.colors.brown,
                                    )
                                    FSBottomBar(
                                        navController = navController,
                                    )
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}