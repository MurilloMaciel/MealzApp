package com.maciel.murillo.mealz.presentation.meals

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maciel.murillo.mealz.domain.repository.MealsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsCategoriesViewModel @Inject constructor(
    private val repository: MealsRepository
) : ViewModel() {

    private val _categoriesState = MutableStateFlow<MealsCategoriesState>(
        value = MealsCategoriesState.Loading
    )
    val categoriesState: StateFlow<MealsCategoriesState> = _categoriesState.asStateFlow()

    fun getMeals() {
        viewModelScope.launch(Dispatchers.IO) {
            val mealsCategories = repository.getMeals()
            _categoriesState.value = MealsCategoriesState.Success(mealsCategories)
        }
    }
}

