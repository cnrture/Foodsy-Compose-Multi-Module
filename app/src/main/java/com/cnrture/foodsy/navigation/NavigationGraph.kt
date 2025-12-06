package com.cnrture.foodsy.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cnrture.foodsy.navigation.Screen.Splash
import com.cnrture.foodsy.navigation.Screen.Onboarding
import com.cnrture.foodsy.navigation.Screen.Login
import com.cnrture.foodsy.navigation.Screen.Register
import com.cnrture.foodsy.navigation.Screen.ForgotPassword
import com.cnrture.foodsy.navigation.Screen.Home
import com.cnrture.foodsy.navigation.Screen.Categories
import com.cnrture.foodsy.navigation.Screen.Favorites
import com.cnrture.foodsy.navigation.Screen.Discount
import com.cnrture.foodsy.navigation.Screen.Submenu
import com.cnrture.foodsy.navigation.Screen.Orders
import com.cnrture.foodsy.navigation.Screen.DishDetail
import com.cnrture.foodsy.navigation.Screen.Cart
import com.cnrture.foodsy.navigation.Screen.ConfirmOrder
import com.cnrture.foodsy.navigation.Screen.OrderComplete
import com.cnrture.foodsy.navigation.Screen.Profile
import com.cnrture.foodsy.navigation.Screen.Search
import com.cnrture.foodsy.ui.splash.SplashScreen
import com.cnrture.foodsy.ui.splash.SplashViewModel
import com.cnrture.foodsy.ui.onboarding.OnboardingScreen
import com.cnrture.foodsy.ui.onboarding.OnboardingViewModel
import com.cnrture.foodsy.ui.login.LoginScreen
import com.cnrture.foodsy.ui.login.LoginViewModel
import com.cnrture.foodsy.ui.register.RegisterScreen
import com.cnrture.foodsy.ui.register.RegisterViewModel
import com.cnrture.foodsy.ui.forgotpassword.ForgotPasswordScreen
import com.cnrture.foodsy.ui.forgotpassword.ForgotPasswordViewModel
import com.cnrture.foodsy.ui.home.HomeScreen
import com.cnrture.foodsy.ui.home.HomeViewModel
import com.cnrture.foodsy.ui.categories.CategoriesScreen
import com.cnrture.foodsy.ui.categories.CategoriesViewModel
import com.cnrture.foodsy.ui.favorites.FavoritesScreen
import com.cnrture.foodsy.ui.favorites.FavoritesViewModel
import com.cnrture.foodsy.ui.discount.DiscountScreen
import com.cnrture.foodsy.ui.discount.DiscountViewModel
import com.cnrture.foodsy.ui.submenu.SubmenuScreen
import com.cnrture.foodsy.ui.submenu.SubmenuViewModel
import com.cnrture.foodsy.ui.orders.OrdersScreen
import com.cnrture.foodsy.ui.orders.OrdersViewModel
import com.cnrture.foodsy.ui.dishdetail.DishDetailScreen
import com.cnrture.foodsy.ui.dishdetail.DishDetailViewModel
import com.cnrture.foodsy.ui.cart.CartScreen
import com.cnrture.foodsy.ui.cart.CartViewModel
import com.cnrture.foodsy.ui.confirmorder.ConfirmOrderScreen
import com.cnrture.foodsy.ui.confirmorder.ConfirmOrderViewModel
import com.cnrture.foodsy.ui.ordercomplete.OrderCompleteScreen
import com.cnrture.foodsy.ui.ordercomplete.OrderCompleteViewModel
import com.cnrture.foodsy.ui.profile.ProfileScreen
import com.cnrture.foodsy.ui.profile.ProfileViewModel
import com.cnrture.foodsy.ui.search.SearchScreen
import com.cnrture.foodsy.ui.search.SearchViewModel

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