package com.maciel.murillo.mealz.data.datasource

import com.maciel.murillo.mealz.domain.model.Category

interface CategoriesLocalDataSource {
    suspend fun saveAll(categories: List<Category>)
    suspend fun getAll(): List<Category>
    suspend fun deleteAll()
    suspend fun getById(id: String): Category
}