package com.maciel.murillo.mealz.data.local

import com.maciel.murillo.mealz.data.datasource.CategoriesLocalDataSource
import com.maciel.murillo.mealz.data.mapper.CategoryEntityToModelMapper
import com.maciel.murillo.mealz.data.mapper.CategoryToCategoryEntityMapper
import com.maciel.murillo.mealz.database.AppDatabase
import com.maciel.murillo.mealz.domain.model.Category
import java.lang.Exception
import javax.inject.Inject

class CategoriesLocalDataSourceImpl @Inject constructor(
    private val database: AppDatabase,
    private val categoryToCategoryEntityMapper: CategoryToCategoryEntityMapper,
    private val categoryEntityToModelMapper: CategoryEntityToModelMapper,
) : CategoriesLocalDataSource {

    private val dao get() = database.userDao()

    override suspend fun saveAll(categories: List<Category>) {
        val categoriesToSave = categories.map { categoryToCategoryEntityMapper(it) }
        dao.updateData(categoriesToSave)
    }

    override suspend fun getAll(): List<Category> {
        return dao.getAll().map { categoryEntityToModelMapper(it) }
    }

    override suspend fun deleteAll() {
        dao.deleteAll()
    }

    override suspend fun getById(id: String): Category {
        return categoryEntityToModelMapper(dao.getById(id))
    }
}