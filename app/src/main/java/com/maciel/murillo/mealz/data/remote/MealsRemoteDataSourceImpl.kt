package com.maciel.murillo.mealz.data.remote

import com.maciel.murillo.mealz.data.datasource.MealsRemoteDataSource
import com.maciel.murillo.mealz.data.mapper.MealResponseToModelMapper
import com.maciel.murillo.mealz.domain.model.Meal
import javax.inject.Inject

class MealsRemoteDataSourceImpl @Inject constructor(
    private val mealsApi: MealsApi,
    private val mealResponseToModelMapper: MealResponseToModelMapper,
) : MealsRemoteDataSource {

    override suspend fun getMealCategories(): List<Meal> {
        return mealsApi.getMealCategories().categories.map {
            mealResponseToModelMapper(it)
        }
    }
}