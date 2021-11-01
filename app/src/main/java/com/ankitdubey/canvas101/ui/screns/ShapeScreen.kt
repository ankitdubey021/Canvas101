package com.ankitdubey.canvas101.ui.screns

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.ankitdubey.canvas101.CardType
import com.ankitdubey.canvas101.cards
import com.ankitdubey.canvas101.ui.components.MToolbar
import com.ankitdubey.canvas101.ui.shapes.*

/**
 * Created by Ankit Dubey on 05,September,2021
 */

@Composable
fun ShapeScreen(navController: NavController, shapeType: String?) {

    val shape = cards.firstOrNull { it.value == shapeType }

    Column() {
        MToolbar(
            title = shapeType ?: "",
            onBackClicked = { navController.popBackStack() }
        ) {
            when (shape) {
                CardType.CHARTS -> ComposePieChart()
                CardType.GIT_CAT -> GithubCatScreen()
                CardType.CLOCK -> CanvasClock()
                CardType.DONUT_SHAPE -> DonutShape()
                CardType.STATE_PICKER -> StatePicker()
            }
        }
    }
}