package com.maciel.murillo.mealz.model

import com.maciel.murillo.mealz.model.response.MealResponse
import com.maciel.murillo.mealz.model.response.MealsCategoriesResponse

interface MealsRepository {
    suspend fun getMeals(): MealsCategoriesResponse
    suspend fun getMealById(id: String): MealResponse
}