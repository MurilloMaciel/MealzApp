package com.maciel.murillo.mealz.data.datasource

import com.maciel.murillo.mealz.domain.model.GetMealCategoriesError
import com.maciel.murillo.mealz.domain.model.Meal
import com.maciel.murillo.mealz.utils.Result

interface MealsRemoteDataSource {
    suspend fun getMealCategories(): Result<List<Meal>, GetMealCategoriesError>
}