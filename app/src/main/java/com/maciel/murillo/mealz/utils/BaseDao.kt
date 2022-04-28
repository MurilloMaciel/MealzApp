package com.maciel.murillo.mealz.utils

import androidx.room.*

interface BaseDao<ENTITY> {

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(entity: ENTITY)

    @Insert
    suspend fun insert(entity: ENTITY): Long

    @Insert
    @JvmSuppressWildcards
    suspend fun insertAll(entities: List<ENTITY>)

    @Delete
    suspend fun delete(entity: ENTITY)
}