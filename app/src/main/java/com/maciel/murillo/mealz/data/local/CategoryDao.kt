package com.maciel.murillo.mealz.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.maciel.murillo.mealz.data.model.CategoryEntity
import com.maciel.murillo.mealz.utils.BaseDao

@Dao
interface CategoryDao : BaseDao<CategoryEntity> {

    @Query("DELETE FROM CATEGORYENTITY")
    suspend fun deleteAll()

    @Query("SELECT * FROM CATEGORYENTITY")
    suspend fun getAll(): List<CategoryEntity>

    @Query("SELECT * FROM CATEGORYENTITY WHERE id = :id")
    suspend fun getById(id: String): CategoryEntity

    @Transaction
    suspend fun updateData(entities: List<CategoryEntity>) {
        deleteAll()
        insertAll(entities)
    }
}