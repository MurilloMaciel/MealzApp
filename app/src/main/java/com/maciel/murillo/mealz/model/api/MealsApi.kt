package com.maciel.murillo.mealz.model.api

import com.maciel.murillo.mealz.model.response.MealsCategoriesResponse
import retrofit2.http.GET

interface MealsApi {

    @GET("categories.php")
    suspend fun getMeals(): MealsCategoriesResponse
}