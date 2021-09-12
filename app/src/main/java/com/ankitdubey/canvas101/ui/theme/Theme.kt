package com.ankitdubey.canvas101.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable


private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200,


    /* Other default colors to override
    ,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun ComposeOnCanvasTheme(
    content: @Composable() () -> Unit
) {
    MaterialTheme(
        colors = LightColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}