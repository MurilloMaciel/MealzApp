package com.maciel.murillo.mealz.presentation.meals

import com.maciel.murillo.mealz.data.model.CategoriesResponse

sealed class MealsCategoriesState {
    object Loading : MealsCategoriesState()
    data class Success(val data: CategoriesResponse) : MealsCategoriesState()
}
