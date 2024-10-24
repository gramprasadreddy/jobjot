package com.example.jobjot.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.ram.jobjot.ui.theme.*

private val LightColorScheme = lightColorScheme(
    primary = FacebookBlue,
    onPrimary = Color.White,
    primaryContainer = FacebookBlueLight,
    secondary = FacebookBlueDark,
    onSecondary = Color.White,
    background = BackgroundColor,
    surface = SurfaceColor,
    onBackground = TextPrimary,
    onSurface = TextPrimary,
    outline = DividerColor
)

@Composable
fun JobJotTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = AppTypography,
        content = content
    )
}
