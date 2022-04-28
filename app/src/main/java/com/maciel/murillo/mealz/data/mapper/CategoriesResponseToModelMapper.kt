package com.maciel.murillo.mealz.data.mapper

import com.maciel.murillo.mealz.data.model.CategoryResponse
import com.maciel.murillo.mealz.domain.model.Category
import com.maciel.murillo.mealz.utils.Mapper
import javax.inject.Inject

class CategoriesResponseToModelMapper @Inject constructor() :
    Mapper<CategoryResponse, Category> {
    override fun invoke(from: CategoryResponse): Category {
        return Category(
            id = from.id,
            name = from.name,
            description = from.description,
            imageUrl = from.imageUrl,
        )
    }
}