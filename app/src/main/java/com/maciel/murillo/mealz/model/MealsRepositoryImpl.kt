package com.maciel.murillo.mealz.model

import com.maciel.murillo.mealz.model.api.MealsApi
import com.maciel.murillo.mealz.model.response.MealsCategoriesResponse
import javax.inject.Inject

class MealsRepositoryImpl @Inject constructor(
    private val mealsApi: MealsApi
) : MealsRepository {
    override suspend fun getMeals(): MealsCategoriesResponse = mealsApi.getMeals()
}