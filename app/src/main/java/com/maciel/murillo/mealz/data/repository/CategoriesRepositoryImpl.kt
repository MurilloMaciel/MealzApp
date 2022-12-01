package com.maciel.murillo.mealz.data.repository

import com.maciel.murillo.mealz.data.datasource.CategoriesLocalDataSource
import com.maciel.murillo.mealz.data.datasource.CategoriesRemoteDataSource
import com.maciel.murillo.mealz.data.remote.CategoriesApi
import com.maciel.murillo.mealz.data.model.CategoryResponse
import com.maciel.murillo.mealz.data.model.CategoriesResponse
import com.maciel.murillo.mealz.domain.model.Category
import com.maciel.murillo.mealz.domain.model.GetCategoriesError
import com.maciel.murillo.mealz.domain.repository.CategoriesRepository
import com.maciel.murillo.mealz.utils.Result
import javax.inject.Inject

class CategoriesRepositoryImpl @Inject constructor(
    private val categoriesRemoteDataSource: CategoriesRemoteDataSource,
    private val categoriesLocalDataSource: CategoriesLocalDataSource,
) : CategoriesRepository {

    override suspend fun getCategories(): Result<List<Category>, GetCategoriesError> {
        val cachedCategories = categoriesLocalDataSource.getAll()

        if (cachedCategories.isNotEmpty()) {
            return Result.Success(cachedCategories)
        }

        return categoriesRemoteDataSource.getMealCategories().onSuccess { categories ->
            categoriesLocalDataSource.saveAll(categories)
        }
    }

    override suspend fun getMealById(id: String): Category {
        return categoriesLocalDataSource.getById(id)
    }
}