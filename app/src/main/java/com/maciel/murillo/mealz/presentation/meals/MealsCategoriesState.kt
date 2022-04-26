package com.maciel.murillo.mealz.presentation.meals

import com.maciel.murillo.mealz.data.model.MealsCategoriesResponse

sealed class MealsCategoriesState {
    object Loading : MealsCategoriesState()
    data class Success(val data: MealsCategoriesResponse) : MealsCategoriesState()
}
