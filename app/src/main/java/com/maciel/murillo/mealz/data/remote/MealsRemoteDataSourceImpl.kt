package com.maciel.murillo.mealz.data.remote

import com.maciel.murillo.mealz.data.datasource.MealsRemoteDataSource
import com.maciel.murillo.mealz.data.mapper.MealResponseToModelMapper
import com.maciel.murillo.mealz.domain.model.GetMealCategoriesError
import com.maciel.murillo.mealz.domain.model.Meal
import com.maciel.murillo.mealz.utils.DispatcherProvider
import com.maciel.murillo.mealz.utils.Result
import com.maciel.murillo.mealz.utils.safeApiCall
import javax.inject.Inject

class MealsRemoteDataSourceImpl @Inject constructor(
    private val mealsApi: MealsApi,
    private val dispatcherProvider: DispatcherProvider,
    private val mealResponseToModelMapper: MealResponseToModelMapper,
) : MealsRemoteDataSource {

    override suspend fun getMealCategories(): Result<List<Meal>, GetMealCategoriesError> {
        return safeApiCall(dispatcherProvider.io()) {
            mealsApi.getMealCategories()
        }.mapSuccess { response ->
            response.categories.map { mealResponseToModelMapper(it) }
        }.mapError { error ->
            GetMealCategoriesError.Network(error)
        }
    }
}