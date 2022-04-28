package com.maciel.murillo.mealz.domain.repository

import com.maciel.murillo.mealz.domain.model.Category
import com.maciel.murillo.mealz.domain.model.GetCategoriesError
import com.maciel.murillo.mealz.utils.Result

interface CategoriesRepository {
    suspend fun getMeals(): Result<List<Category>, GetCategoriesError>
    suspend fun getMealById(id: String): Category
}