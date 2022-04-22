package com.maciel.murillo.mealz.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.maciel.murillo.mealz.ui.meals.MealsCategoriesScreen
import com.maciel.murillo.mealz.ui.theme.MealzTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealzTheme {
                MealsCategoriesScreen()
            }
        }
    }
}