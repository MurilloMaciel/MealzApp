package com.maciel.murillo.mealz.data.mapper

import com.maciel.murillo.mealz.data.model.CategoryEntity
import com.maciel.murillo.mealz.domain.model.Category
import com.maciel.murillo.mealz.utils.Mapper
import javax.inject.Inject

class CategoryToCategoryEntityMapper @Inject constructor() : Mapper<Category, CategoryEntity> {
    override fun mapFrom(from: Category): CategoryEntity {
        return CategoryEntity(
            id = from.id,
            name = from.name,
            description = from.description,
            imageUrl = from.imageUrl,
        )
    }
}