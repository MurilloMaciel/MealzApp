package com.maciel.murillo.mealz.di

import com.maciel.murillo.mealz.model.MealsRepository
import com.maciel.murillo.mealz.model.MealsRepositoryImpl
import com.maciel.murillo.mealz.model.api.MealsApi
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ViewModelComponent::class)
interface AppModule {

    @Binds
    fun bindRepository(repository: MealsRepositoryImpl): MealsRepository

    companion object {

        @Provides
        fun provideApi(): MealsApi {
            return Retrofit.Builder()
                .baseUrl("https://www.themealdb.com/api/json/v1/1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MealsApi::class.java)
        }
    }
}