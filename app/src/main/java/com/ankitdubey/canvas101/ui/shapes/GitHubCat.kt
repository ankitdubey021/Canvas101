package com.ankitdubey.canvas101.ui.shapes

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ankitdubey.canvas101.ui.theme.BLACK_LIGHT
import kotlin.math.PI
import kotlin.math.atan
import kotlin.math.atan2

/**
 * Created by Ankit Dubey on 01,September,2021
 */

@Composable
fun GithubCatScreen(){
    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Box(
            modifier = Modifier
                .height(300.dp)
                .width(300.dp)
                .background(Color.Black)
        ) {
            GithubCat()
        }
    }
}

@Composable
private fun GithubCat() {

    val infiniteTransition = rememberInfiniteTransition()
    val phase by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 10000f,
        animationSpec = infiniteRepeatable(
            animation = tween(60000, easing = LinearEasing)
        )
    )

    Canvas(modifier = Modifier.fillMaxSize()) {
        val catPath = getCatPath()
        drawPath(path = catPath, color = White, style = Stroke(width = 5f))

        val animatedPath = getCatPath()
        val outputPath = android.graphics.Path()
        val pos = FloatArray(2)
        val tan = FloatArray(2)

        android.graphics.PathMeasure().apply {
            setPath(animatedPath.asAndroidPath(), false)
            getSegment(0f, phase * length, outputPath, true)
            getPosTan(phase * length, pos, tan)
        }

        clipPath(path = Path().apply {
            moveTo(0f, 0f)
            lineTo(0f, size.height)
            lineTo(size.width, size.height)
            lineTo(size.width, 0f)
            close()
        }) {

            val oval = Path().apply {
                addOval(Rect(topLeft = Offset.Zero, bottomRight = Offset(70f, 20f)))
            }

            drawPath(
                path = outputPath.asComposePath(), color = Color.Red,
                style = Stroke(
                    width = 5f,
                    /*pathEffect = PathEffect.dashPathEffect(
                        intervals = floatArrayOf(50f,30f),
                        phase = phase
                    )*/
                    pathEffect = PathEffect.stampedPathEffect(
                        shape = oval,
                        phase = phase,
                        advance = 100f,
                        style = StampedPathEffectStyle.Morph
                    )
                )
            )



            drawPath(
                path = getTailPath(),
                color = Color.White,
                style = Stroke(
                    width = 5f,
                    pathEffect = PathEffect.dashPathEffect(
                        intervals = floatArrayOf(50f, 30f),
                        phase = phase
                    )
                )
            )
        }
    }
}

private fun DrawScope.getTailPath(): Path {
    val w = size.width
    val h = size.height

    val w3 = w / 3
    val h4 = h / 4
    val h6 = h / 6
    val w10 = w * 10 / 100
    val w20 = w * 20 / 100

    return Path().apply {
        moveTo(w3 + 25, h - h6 / 2)
        cubicTo(w20, h - h4 / 5, w20, h - h4, w10, h - h4)
    }
}

private fun DrawScope.getCatPath(): Path {
    val w = size.width
    val h = size.height

    val w10 = w * 10 / 100
    val h10 = h * 10 / 100
    val w20 = w * 20 / 100
    val w35 = w * 35 / 100
    val w3 = w / 3
    val h4 = h / 4
    val h6 = h / 6

    val path = Path().apply {
        moveTo(w - w3, h)

        lineTo(w - w3, h - h6)
        quadraticBezierTo(w - w3, h - h4, w - w3 - 50, h - h4 - 50)

        //right cheek
        quadraticBezierTo(w - w10 / 2, (h + h4) / 2, w - w20, h4)

        //right ear
        quadraticBezierTo(w - w20 / 1.2f, (h4 + h4 / 2) / 2, w - w20, h10 - h10 / 5)
        quadraticBezierTo(w - (w35 + h4) / 2, h4 / 2.50f, w - w35, (h4 + h4 / 2) / 2)

        //head
        quadraticBezierTo((w35 + w - w35) / 2, h10 + h10 / 1.9f, w35, (h4 + h4 / 2) / 2)

        //left ear
        quadraticBezierTo(w20 + w10, h10, w20, h10 - h10 / 5)
        quadraticBezierTo(w20 - w20 / 5, h4 - h4 / 3, w20, h4)

        //left cheek
        quadraticBezierTo(w10 / 2, h / 1.6f, w3 + 70, h - h4 - 50)

        //left leg
        quadraticBezierTo(w3 + 20, h - h / 4, w3 + 25, h - h6)
        lineTo(w3 + 25, h)

    }
    return path
}


@Preview
@Composable
fun GithubCatPrev() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .height(300.dp)
                .width(300.dp)
                .background(Color.Black)
        ) {
            GithubCat()
        }
    }
}