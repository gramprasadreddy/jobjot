package com.ram.jobjot.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ram.jobjot.nav.bottomnav.BottomNavItem

@Composable
fun JobTrackerScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Text(text = "JobTracker Screen", style = MaterialTheme.typography.headlineMedium)
        // Add job tracking and dashboard widgets here.
    }
}
