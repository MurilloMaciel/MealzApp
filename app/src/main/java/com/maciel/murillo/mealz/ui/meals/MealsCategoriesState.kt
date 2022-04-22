package com.maciel.murillo.mealz.ui.meals

import com.maciel.murillo.mealz.model.response.MealsCategoriesResponse

sealed class MealsCategoriesState {
    object Loading : MealsCategoriesState()
    data class Success(val data: MealsCategoriesResponse) : MealsCategoriesState()
}
