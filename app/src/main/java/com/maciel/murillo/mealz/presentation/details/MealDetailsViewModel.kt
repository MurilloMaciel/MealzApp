package com.maciel.murillo.mealz.presentation.details

import androidx.lifecycle.ViewModel
import com.maciel.murillo.mealz.domain.repository.MealsRepository
import com.maciel.murillo.mealz.data.model.MealResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MealDetailsViewModel @Inject constructor(
    private val repository: MealsRepository
) : ViewModel() {

    private val _mealState = MutableStateFlow<MealResponse?>(value = null)
    val mealState: StateFlow<MealResponse?> = _mealState.asStateFlow()

    fun onInitScreen(categoryId: String?) {
        TODO("Not yet implemented")
    }
}