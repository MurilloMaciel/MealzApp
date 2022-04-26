package com.maciel.murillo.mealz.data.datasource

import com.maciel.murillo.mealz.domain.model.Meal

interface MealsRemoteDataSource {
    suspend fun getMealCategories(): List<Meal>
}