package com.ram.jobjot.nav.bottomnav

import androidx.annotation.DrawableRes
import com.ram.jobjot.R // Replace with your actual icons

sealed class BottomNavItem(val route: String, val title: String, @DrawableRes val icon: Int) {
    object Home : BottomNavItem("home", "Home", R.drawable.home)
    object Search : BottomNavItem("search", "Search", R.drawable.search)
    object JobTracker : BottomNavItem("job_tracker", "Tracker", R.drawable.track)
    object Profile : BottomNavItem("profile", "Profile", R.drawable.profile)
}
