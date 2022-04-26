package com.maciel.murillo.mealz.data.repository

import com.maciel.murillo.mealz.data.remote.MealsApi
import com.maciel.murillo.mealz.data.model.MealResponse
import com.maciel.murillo.mealz.data.model.MealsCategoriesResponse
import com.maciel.murillo.mealz.domain.repository.MealsRepository
import javax.inject.Inject

class MealsRepositoryImpl @Inject constructor(
    private val mealsApi: MealsApi
) : MealsRepository {

    override suspend fun getMeals(): MealsCategoriesResponse = mealsApi.getMealCategories()

    override suspend fun getMealById(id: String): MealResponse {
        TODO("Not yet implemented")
    }
}