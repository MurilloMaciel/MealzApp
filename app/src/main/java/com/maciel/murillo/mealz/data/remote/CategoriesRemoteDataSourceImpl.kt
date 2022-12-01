package com.maciel.murillo.mealz.data.remote

import com.maciel.murillo.mealz.data.datasource.CategoriesRemoteDataSource
import com.maciel.murillo.mealz.data.mapper.CategoriesResponseToModelMapper
import com.maciel.murillo.mealz.domain.model.GetCategoriesError
import com.maciel.murillo.mealz.domain.model.Category
import com.maciel.murillo.mealz.utils.DispatcherProvider
import com.maciel.murillo.mealz.utils.Result
import com.maciel.murillo.mealz.utils.safeApiCall
import javax.inject.Inject

class CategoriesRemoteDataSourceImpl @Inject constructor(
    private val categoriesApi: CategoriesApi,
    private val dispatcherProvider: DispatcherProvider,
    private val mealResponseToModelMapper: CategoriesResponseToModelMapper,
) : CategoriesRemoteDataSource {

    override suspend fun getMealCategories(): Result<List<Category>, GetCategoriesError> {
        return safeApiCall(dispatcherProvider.io()) {
            categoriesApi.getMealCategories()
        }.mapSuccess { response ->
            response.categories.map { mealResponseToModelMapper.mapFrom(it) }
        }.mapError { error ->
            GetCategoriesError.Network(error)
        }
    }
}