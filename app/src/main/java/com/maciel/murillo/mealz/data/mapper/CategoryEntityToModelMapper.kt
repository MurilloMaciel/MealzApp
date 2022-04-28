package com.maciel.murillo.mealz.data.mapper

import com.maciel.murillo.mealz.data.model.CategoryEntity
import com.maciel.murillo.mealz.domain.model.Category
import com.maciel.murillo.mealz.utils.Mapper
import javax.inject.Inject

class CategoryEntityToModelMapper @Inject constructor() : Mapper<CategoryEntity, Category> {
    override fun invoke(from: CategoryEntity): Category {
        return Category(
            id = from.id,
            name = from.name,
            description = from.description,
            imageUrl = from.imageUrl,
        )
    }
}