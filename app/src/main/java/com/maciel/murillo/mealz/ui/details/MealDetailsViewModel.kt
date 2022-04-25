package com.maciel.murillo.mealz.ui.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.maciel.murillo.mealz.model.response.MealResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

@HiltViewModel
class MealDetailsViewModel (
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _mealState = MutableStateFlow<MealResponse?>(value = null)
    val mealState: StateFlow<MealResponse?> = _mealState.asStateFlow()

    init {
        val id = savedStateHandle.get<String>("category_id").orEmpty()
        _mealState.value = savedStateHandle.get<String>("category_id")
    }
}