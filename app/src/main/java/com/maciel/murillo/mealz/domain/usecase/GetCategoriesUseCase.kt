package com.maciel.murillo.mealz.domain.usecase

import com.maciel.murillo.mealz.domain.model.Category
import com.maciel.murillo.mealz.domain.model.GetCategoriesError
import com.maciel.murillo.mealz.utils.Result

interface GetCategoriesUseCase {
    suspend operator fun invoke(): Result<List<Category>, GetCategoriesError>
}