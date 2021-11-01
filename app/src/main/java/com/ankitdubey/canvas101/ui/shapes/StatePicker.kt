package com.ankitdubey.canvas101.ui.shapes

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ankitdubey.canvas101.R
import com.ankitdubey.canvas101.ui.theme.DARK_TEAL
import com.ankitdubey.canvas101.ui.theme.WHITE_LIGHT

/**
 * Created by Ankit Dubey on 01,November,2021
 */

@Composable
fun StatePicker() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DARK_TEAL)
            .scale(1.5f),
        contentAlignment = Alignment.Center
    ) {
        IndianMap()
    }

}

@Composable
private fun IndianMap() {

    var selectedState : State? = null

    val kashmir = stringResource(id = R.string.j_and_k)
    val mp = stringResource(id = R.string.mp)
    val odisa = stringResource(id = R.string.odisa)
    val punjab = stringResource(id = R.string.punjab)
    val rj = stringResource(id = R.string.rajisthan)
    val sikkim = stringResource(id = R.string.sikkim)
    val tamilnadu = stringResource(id = R.string.tamilnadu_path)
    val telangana = stringResource(id = R.string.telangana)
    val up = stringResource(id = R.string.up_path)
    val uttarakhand = stringResource(id = R.string.uk_path)

    val kashmirPath = remember { PathParser().parsePathString(kashmir).toPath() }
    val mpPath = remember { PathParser().parsePathString(mp).toPath() }
    val odisaPath = remember { PathParser().parsePathString(odisa).toPath() }
    val punjabPath = remember { PathParser().parsePathString(punjab).toPath() }
    val rajisthanPath = remember { PathParser().parsePathString(rj).toPath() }
    val sikkimPath = remember { PathParser().parsePathString(sikkim).toPath() }
    val tamilnaduPath = remember { PathParser().parsePathString(tamilnadu).toPath() }
    val telanganaPath = remember { PathParser().parsePathString(telangana).toPath() }
    val upPath = remember { PathParser().parsePathString(up).toPath() }
    val uttarakhandPath = remember { PathParser().parsePathString(uttarakhand).toPath() }

    var selectedPath = remember {
        mutableStateOf(Path())
    }

    val selectionRadius = remember {
        Animatable(initialValue = 0f)
    }

    val resetRadius = remember {
        mutableStateOf(false)
    }

    if (resetRadius.value) {
        LaunchedEffect(key1 = true) {
            selectionRadius.snapTo(0f)
            selectionRadius.animateTo(
                100f, animationSpec = tween(300)
            )
            resetRadius.value = false
        }
    }


    Canvas(
        modifier = Modifier
            .width(200.dp)
            .height(300.dp)
            .pointerInput(true) {
                detectTapGestures {
                    val touched = Path().apply {
                        addRect(
                            Rect(
                                offset = it,
                                size = Size(width = 10f, height = 10f)
                            )
                        )
                    }

                    when {
                        touched inside mpPath -> {
                            if(selectedState != State.MP) {

                                resetRadius.value = true

                                selectedState = State.MP
                                selectedPath.value = mpPath
                            }
                        }
                        touched inside upPath -> {
                            if(selectedState != State.UP) {

                                resetRadius.value = true

                                selectedState = State.UP
                                selectedPath.value = upPath
                            }
                        }
                        touched inside odisaPath -> {
                            if(selectedState != State.ODISA) {

                                resetRadius.value = true

                                selectedState = State.ODISA
                                selectedPath.value = odisaPath
                            }
                        }
                        touched inside punjabPath -> selectedPath.value = punjabPath
                        touched inside sikkimPath -> selectedPath.value = sikkimPath
                        touched inside kashmirPath -> selectedPath.value = kashmirPath
                        touched inside rajisthanPath -> selectedPath.value = rajisthanPath
                        touched inside tamilnaduPath -> selectedPath.value = tamilnaduPath
                        touched inside telanganaPath -> selectedPath.value = telanganaPath
                        touched inside uttarakhandPath -> selectedPath.value = uttarakhandPath
                    }
                }
            }
    ) {
        drawState(kashmirPath)
        drawState(mpPath)
        drawState(odisaPath)
        drawState(punjabPath)
        drawState(rajisthanPath)
        drawState(sikkimPath)
        drawState(upPath)
        drawState(uttarakhandPath)
        drawState(tamilnaduPath)
        drawState(telanganaPath)

        clipPath(selectedPath.value) {

            drawCircle(
                color = WHITE_LIGHT,
                radius = selectionRadius.value + 1f,
                center = selectedPath.value.getBounds().center
            )
        }
    }
}

private infix fun Path.inside(parentPath: Path): Boolean {
    val pathOp = Path().apply {
        op(parentPath, this@inside, PathOperation.Intersect)
    }
    return !pathOp.isEmpty
}

private fun DrawScope.drawState(path: Path) {
    drawPath(
        path,
        Color.White,
        style = Stroke(
            width = 2.5f
        )
    )
}

private enum class State(val value: String) {
    UP("Uttar Pradesh"),
    MP("Madhya Pradesh"),
    KASHMIR("Jammu And Kashmir"),
    TELANGANA("Telangana"),
    ODISA("Odisa"),
    PUNJAB("Punjab"),
    SIKKIM("Sikkim"),
    UTTARAKHAND("Uttarakhand"),
    TAMILNADU("Tamilnadu")
}

@Preview
@Composable
fun PathBasicsPreview() {
    StatePicker()
}