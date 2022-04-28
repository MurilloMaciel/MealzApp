package com.maciel.murillo.mealz.presentation.details

import androidx.lifecycle.ViewModel
import com.maciel.murillo.mealz.domain.repository.CategoriesRepository
import com.maciel.murillo.mealz.data.model.CategoryResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MealDetailsViewModel @Inject constructor(
    private val repository: CategoriesRepository
) : ViewModel() {

    private val _mealState = MutableStateFlow<CategoryResponse?>(value = null)
    val categoryState: StateFlow<CategoryResponse?> = _mealState.asStateFlow()

    fun onInitScreen(categoryId: String?) {
        TODO("Not yet implemented")
    }
}