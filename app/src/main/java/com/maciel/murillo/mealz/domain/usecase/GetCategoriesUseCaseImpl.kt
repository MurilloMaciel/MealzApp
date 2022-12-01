package com.maciel.murillo.mealz.domain.usecase

import com.maciel.murillo.mealz.domain.model.Category
import com.maciel.murillo.mealz.domain.model.GetCategoriesError
import com.maciel.murillo.mealz.domain.repository.CategoriesRepository
import com.maciel.murillo.mealz.utils.Result
import javax.inject.Inject

class GetCategoriesUseCaseImpl @Inject constructor(
    private val repository: CategoriesRepository
) : GetCategoriesUseCase {

    override suspend fun invoke(): Result<List<Category>, GetCategoriesError> {
        return repository.getCategories()
    }
}