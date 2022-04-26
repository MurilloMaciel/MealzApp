package com.maciel.murillo.mealz.utils

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface UtilsModule {
    @Binds
    fun bindDispatcherProvider(dispatcherProvider: DispatcherProviderImpl): DispatcherProvider
}