package com.maciel.murillo.mealz.data.model

import com.google.gson.annotations.SerializedName

data class CategoriesResponse(val categories: List<CategoryResponse>)

data class CategoryResponse(
    @SerializedName("idCategory") val id: String,
    @SerializedName("strCategory") val name: String,
    @SerializedName("strCategoryDescription") val description: String,
    @SerializedName("strCategoryThumb") val imageUrl: String,
)