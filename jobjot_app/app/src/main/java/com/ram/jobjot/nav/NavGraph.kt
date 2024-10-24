package com.example.jobjot.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ram.jobjot.dashboard.DashboardScreen
import com.ram.jobjot.ui.screens.AuthScreen
import com.ram.jobjot.ui.screens.HomeScreen
import com.ram.jobjot.ui.screens.SplashScreen
import com.ram.jobjot.ui.screens.SplashViewModel

sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")
    object Auth : Screen("auth_screen")
    object Dashboard : Screen("dashboard_screen")
}

@Composable
fun SetupNavGraph(navController: NavHostController,splashViewModel: SplashViewModel = viewModel()) {
    NavHost(navController = navController, startDestination = Screen.Auth.route) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController, splashViewModel)
        }
        composable(route = Screen.Auth.route) {
            AuthScreen(navController)
        }
        composable(route = Screen.Dashboard.route) {
            DashboardScreen()
        }
    }
}
