package com.ram.jobjot.nav.bottomnav

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ram.jobjot.ui.theme.FacebookBlue

@Composable
fun BottomNavigationBar(navController: NavController, items: List<BottomNavItem>) {
    NavigationBar(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White), // Facebook-style background color
        tonalElevation = 8.dp // Slight elevation to separate from content
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = { navController.navigate(item.route) },
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title
                    )
                },
                label = {
                    Text(text = item.title)
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = FacebookBlue, // Facebook blue for selected
                    unselectedIconColor = Color.Gray, // Gray for unselected
                    selectedTextColor = FacebookBlue,
                    unselectedTextColor = Color.Gray,

                )
            )
        }
    }
}
