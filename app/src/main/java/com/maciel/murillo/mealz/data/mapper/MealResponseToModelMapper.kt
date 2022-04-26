package com.maciel.murillo.mealz.data.mapper

import com.maciel.murillo.mealz.data.model.MealResponse
import com.maciel.murillo.mealz.domain.model.Meal

interface MealResponseToModelMapper {
    operator fun invoke(from: MealResponse): Meal
}