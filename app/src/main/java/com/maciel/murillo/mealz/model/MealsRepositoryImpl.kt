package com.maciel.murillo.mealz.model

import com.maciel.murillo.mealz.model.api.MealsApi
import com.maciel.murillo.mealz.model.response.MealResponse
import com.maciel.murillo.mealz.model.response.MealsCategoriesResponse
import javax.inject.Inject

class MealsRepositoryImpl @Inject constructor(
    private val mealsApi: MealsApi
) : MealsRepository {

    override suspend fun getMeals(): MealsCategoriesResponse = mealsApi.getMeals()

    override suspend fun getMealById(id: String): MealResponse {
        TODO("Not yet implemented")
    }
}