package com.ankitdubey.canvas101.ui.shapes

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Created by Ankit Dubey on 05,September,2021
 */

@Composable
fun ComposePieChart() {
    Column(modifier = Modifier.fillMaxSize()) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Row(
                modifier = Modifier.padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {

                PieChart(
                    modifier = Modifier
                        .width(150.dp)
                        .height(150.dp),
                    progress = listOf(40f, 30f, 57f),
                    colors = listOf(
                        Color(0xFFbf95d4),
                        Color(0xFFf9ce71),
                        Color(0xFF8b0a50),
                    ),
                    isDonut = true,
                    percentColor = Color.Black
                )

                PieChart(
                    modifier = Modifier
                        .width(150.dp)
                        .height(150.dp),
                    progress = listOf(40f, 30f, 22f, 57f, 15f),
                    colors = listOf(
                        Color(0xFFc76b6b),
                        Color(0xFF8fb9ce),
                        Color(0xFF7e2828),
                        Color(0xFF0b245a),
                        Color(0xFFd8c05c),
                    ),
                )
            }
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
        ) {
            LineChart(strokeColor = Color(0xFF7e2828))
        }
    }
}

@Preview
@Composable
fun MPreview() {
    ComposePieChart()
}