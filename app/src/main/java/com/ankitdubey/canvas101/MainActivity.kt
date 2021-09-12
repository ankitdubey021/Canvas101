package com.ankitdubey.canvas101

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.ankitdubey.canvas101.ui.screns.HomeScreen
import com.ankitdubey.canvas101.ui.screns.ShapeScreen
import com.ankitdubey.canvas101.ui.theme.ComposeOnCanvasTheme

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val navController = rememberNavController()
            ComposeOnCanvasTheme {
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") { HomeScreen(navController) }
                    composable(
                        "shapeScreen/{shape}",
                        arguments = listOf(navArgument("shape"){

                        })
                    ) { backStackEntry ->
                        ShapeScreen(navController, backStackEntry.arguments?.getString("shape"))
                    }
                }
            }
        }
    }
}