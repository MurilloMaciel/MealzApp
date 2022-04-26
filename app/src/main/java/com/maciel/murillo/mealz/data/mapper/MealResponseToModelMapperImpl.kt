package com.maciel.murillo.mealz.data.mapper

import com.maciel.murillo.mealz.data.model.MealResponse
import com.maciel.murillo.mealz.domain.model.Meal
import javax.inject.Inject

class MealResponseToModelMapperImpl @Inject constructor() : MealResponseToModelMapper {
    override fun invoke(from: MealResponse): Meal {
        return Meal(
            id = from.id,
            name = from.name,
            description = from.description,
            imageUrl = from.imageUrl,
        )
    }
}