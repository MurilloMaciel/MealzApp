package com.maciel.murillo.mealz.di

import com.maciel.murillo.mealz.data.datasource.CategoriesLocalDataSource
import com.maciel.murillo.mealz.data.datasource.CategoriesRemoteDataSource
import com.maciel.murillo.mealz.data.local.CategoriesLocalDataSourceImpl
import com.maciel.murillo.mealz.domain.repository.CategoriesRepository
import com.maciel.murillo.mealz.data.repository.CategoriesRepositoryImpl
import com.maciel.murillo.mealz.data.remote.CategoriesApi
import com.maciel.murillo.mealz.data.remote.CategoriesRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ViewModelComponent::class)
interface CategoriesModule {

    @Binds
    fun bindRepository(repository: CategoriesRepositoryImpl): CategoriesRepository

    @Binds
    fun bindRemoteDataSource(dataSource: CategoriesRemoteDataSourceImpl): CategoriesRemoteDataSource

    @Binds
    fun bindCategoriesLocalDataSource(dataSource: CategoriesLocalDataSourceImpl): CategoriesLocalDataSource

    companion object {

        @Provides
        fun provideApi(): CategoriesApi {
            return Retrofit.Builder()
                .baseUrl("https://www.themealdb.com/api/json/v1/1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CategoriesApi::class.java)
        }
    }
}