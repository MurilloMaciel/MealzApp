package com.maciel.murillo.mealz.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.maciel.murillo.mealz.ui.details.MealDetailsScreen
import com.maciel.murillo.mealz.ui.meals.MealsCategoriesScreen
import com.maciel.murillo.mealz.ui.theme.MealzTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealzTheme {
                MyApp()
            }
        }
    }
}

@Composable
private fun MyApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "meals_list",
    ) {
        composable(route = "meals_list") {
            MealsCategoriesScreen() { navigationMealId ->
                navController.navigate(
                    route = "meal_details/$navigationMealId"
                )
            }
        }
        composable(
            route = "meal_details/category_id",
            arguments = listOf(
                navArgument(name = "category_id") {
                    type = NavType.StringType
                    nullable = true
                }
            )
        ) { navBackStackEntry ->
            val categoryId = navBackStackEntry.arguments?.getString("category_id")
            MealDetailsScreen(categoryId)
        }
    }
}