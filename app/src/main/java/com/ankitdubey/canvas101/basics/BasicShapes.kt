package com.ankitdubey.canvas101.basics

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BasicShapes() {
    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        drawCircle(
            color = Color.Red,
            radius = 200f,
            style = Stroke(
                10f
            )
        )

        drawCircle(
            color = Color.Green,
            radius = 100f,
            center = Offset(100f, 100f)
        )

        drawCircle(
            radius = 200f,
            center = Offset(400f, 400f),
            brush = Brush.radialGradient(
                colors = listOf(Color.Green, Color.Yellow, Color.Red),
                radius = 200f,
                center = Offset(400f, 400f)
            ),
        )
    }
}


@Preview
@Composable
fun BasicShapesPrev() {
    BasicShapes()
}