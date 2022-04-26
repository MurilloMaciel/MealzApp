package com.maciel.murillo.mealz.domain.model

sealed class GetMealCategoriesError {
    object GenericError: GetMealCategoriesError()
}
