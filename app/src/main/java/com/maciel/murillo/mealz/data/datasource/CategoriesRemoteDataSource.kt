package com.maciel.murillo.mealz.data.datasource

import com.maciel.murillo.mealz.domain.model.GetCategoriesError
import com.maciel.murillo.mealz.domain.model.Category
import com.maciel.murillo.mealz.utils.Result

interface CategoriesRemoteDataSource {
    suspend fun getMealCategories(): Result<List<Category>, GetCategoriesError>
}