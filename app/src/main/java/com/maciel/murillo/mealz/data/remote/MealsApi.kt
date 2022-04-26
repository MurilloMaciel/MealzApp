package com.maciel.murillo.mealz.data.remote

import com.maciel.murillo.mealz.data.model.MealsCategoriesResponse
import retrofit2.http.GET

interface MealsApi {

    @GET("categories.php")
    suspend fun getMealCategories(): MealsCategoriesResponse
}