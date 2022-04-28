package com.maciel.murillo.mealz.data.remote

import com.maciel.murillo.mealz.data.model.CategoriesResponse
import retrofit2.http.GET

interface CategoriesApi {

    @GET("categories.php")
    suspend fun getMealCategories(): CategoriesResponse
}