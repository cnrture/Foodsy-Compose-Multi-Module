package com.canerture.foodsy.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.canerture.foodsy.navigation.Screen.Splash
import com.canerture.foodsy.navigation.Screen.Onboarding
import com.canerture.foodsy.navigation.Screen.Login
import com.canerture.foodsy.navigation.Screen.Register
import com.canerture.foodsy.navigation.Screen.ForgotPassword
import com.canerture.foodsy.navigation.Screen.Home
import com.canerture.foodsy.navigation.Screen.Categories
import com.canerture.foodsy.navigation.Screen.Favorites
import com.canerture.foodsy.navigation.Screen.Discount
import com.canerture.foodsy.navigation.Screen.Submenu
import com.canerture.foodsy.navigation.Screen.Orders
import com.canerture.foodsy.navigation.Screen.DishDetail
import com.canerture.foodsy.navigation.Screen.Cart
import com.canerture.foodsy.navigation.Screen.ConfirmOrder
import com.canerture.foodsy.navigation.Screen.OrderComplete
import com.canerture.foodsy.navigation.Screen.Profile
import com.canerture.foodsy.navigation.Screen.Search
import com.canerture.foodsy.ui.splash.SplashScreen
import com.canerture.foodsy.ui.splash.SplashViewModel
import com.canerture.foodsy.ui.onboarding.OnboardingScreen
import com.canerture.foodsy.ui.onboarding.OnboardingViewModel
import com.canerture.foodsy.ui.login.LoginScreen
import com.canerture.foodsy.ui.login.LoginViewModel
import com.canerture.foodsy.ui.register.RegisterScreen
import com.canerture.foodsy.ui.register.RegisterViewModel
import com.canerture.foodsy.ui.forgotpassword.ForgotPasswordScreen
import com.canerture.foodsy.ui.forgotpassword.ForgotPasswordViewModel
import com.canerture.foodsy.ui.home.HomeScreen
import com.canerture.foodsy.ui.home.HomeViewModel
import com.canerture.foodsy.ui.categories.CategoriesScreen
import com.canerture.foodsy.ui.categories.CategoriesViewModel
import com.canerture.foodsy.ui.favorites.FavoritesScreen
import com.canerture.foodsy.ui.favorites.FavoritesViewModel
import com.canerture.foodsy.ui.discount.DiscountScreen
import com.canerture.foodsy.ui.discount.DiscountViewModel
import com.canerture.foodsy.ui.submenu.SubmenuScreen
import com.canerture.foodsy.ui.submenu.SubmenuViewModel
import com.canerture.foodsy.ui.orders.OrdersScreen
import com.canerture.foodsy.ui.orders.OrdersViewModel
import com.canerture.foodsy.ui.dishdetail.DishDetailScreen
import com.canerture.foodsy.ui.dishdetail.DishDetailViewModel
import com.canerture.foodsy.ui.cart.CartScreen
import com.canerture.foodsy.ui.cart.CartViewModel
import com.canerture.foodsy.ui.confirmorder.ConfirmOrderScreen
import com.canerture.foodsy.ui.confirmorder.ConfirmOrderViewModel
import com.canerture.foodsy.ui.ordercomplete.OrderCompleteScreen
import com.canerture.foodsy.ui.ordercomplete.OrderCompleteViewModel
import com.canerture.foodsy.ui.profile.ProfileScreen
import com.canerture.foodsy.ui.profile.ProfileViewModel
import com.canerture.foodsy.ui.search.SearchScreen
import com.canerture.foodsy.ui.search.SearchViewModel

@Composable
fun NavigationGraph(
    navController: NavHostController,
    startDestination: Screen,
    modifier: Modifier = Modifier,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,
    ) {
        composable<Splash> {
            val viewModel: SplashViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            SplashScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction
            )
        }
        composable<Onboarding> {
            val viewModel: OnboardingViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            OnboardingScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction
            )
        }
        composable<Login> {
            val viewModel: LoginViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            LoginScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction
            )
        }
        composable<Register> {
            val viewModel: RegisterViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            RegisterScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction
            )
        }
        composable<ForgotPassword> {
            val viewModel: ForgotPasswordViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            ForgotPasswordScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction
            )
        }
        composable<Home> {
            val viewModel: HomeViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            HomeScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction
            )
        }
        composable<Categories> {
            val viewModel: CategoriesViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            CategoriesScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction
            )
        }
        composable<Favorites> {
            val viewModel: FavoritesViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            FavoritesScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction
            )
        }
        composable<Discount> {
            val viewModel: DiscountViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            DiscountScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction
            )
        }
        composable<Submenu> {
            val viewModel: SubmenuViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            SubmenuScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction
            )
        }
        composable<Orders> {
            val viewModel: OrdersViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            OrdersScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction
            )
        }
        composable<DishDetail> {
            val viewModel: DishDetailViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            DishDetailScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction
            )
        }
        composable<Cart> {
            val viewModel: CartViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            CartScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction
            )
        }
        composable<ConfirmOrder> {
            val viewModel: ConfirmOrderViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            ConfirmOrderScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction
            )
        }
        composable<OrderComplete> {
            val viewModel: OrderCompleteViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            OrderCompleteScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction
            )
        }
        composable<Profile> {
            val viewModel: ProfileViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            ProfileScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction
            )
        }
        composable<Search> {
            val viewModel: SearchViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            SearchScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction
            )
        }
    }
}