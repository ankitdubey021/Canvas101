package com.ankitdubey.canvas101.ui.screns

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ankitdubey.canvas101.cards
import com.ankitdubey.canvas101.ui.components.MToolbar
import com.ankitdubey.canvas101.ui.components.ShapeCard

/**
 * Created by Ankit Dubey on 04,September,2021
 */

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun HomeScreen(navController: NavController) {
    MToolbar(title = "Canvas101") {
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            modifier = Modifier.padding(vertical = 16.dp, horizontal = 8.dp)
        ) {
            items(cards) { item ->
                ShapeCard(item, onCardClicked = {
                    navController.navigate("shapeScreen/${item.value}")
                })
            }
        }
    }
}