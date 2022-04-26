package com.maciel.murillo.mealz.domain.repository

import com.maciel.murillo.mealz.data.model.MealResponse
import com.maciel.murillo.mealz.data.model.MealsCategoriesResponse

interface MealsRepository {
    suspend fun getMeals(): MealsCategoriesResponse
    suspend fun getMealById(id: String): MealResponse
}