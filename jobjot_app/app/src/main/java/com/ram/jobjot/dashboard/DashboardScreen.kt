package com.ram.jobjot.dashboard

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ram.jobjot.nav.bottomnav.BottomNavItem
import com.ram.jobjot.nav.bottomnav.BottomNavigationBar
import com.ram.jobjot.ui.screens.HomeScreen
import com.ram.jobjot.ui.screens.JobTrackerScreen
import com.ram.jobjot.ui.screens.ProfileScreen
import com.ram.jobjot.ui.screens.SearchScreen

@Composable
fun DashboardScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                items = listOf(
                    BottomNavItem.Home,
                    BottomNavItem.Search,
                    BottomNavItem.JobTracker,
                    BottomNavItem.Profile
                )
            )
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = BottomNavItem.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(BottomNavItem.Home.route) { HomeScreen() }
            composable(BottomNavItem.Search.route) { SearchScreen() }
            composable(BottomNavItem.JobTracker.route) { JobTrackerScreen() }
            composable(BottomNavItem.Profile.route) { ProfileScreen() }
//            composable(BottomNavItem.Analytics.route) { AnalyticsScreen() }
//            composable(BottomNavItem.Profile.route) { ProfileScreen() }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    DashboardScreen()
}
