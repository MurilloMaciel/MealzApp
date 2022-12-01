package com.maciel.murillo.mealz.domain.model

import com.maciel.murillo.mealz.utils.ResultError

sealed class GetCategoriesError {

    object Generic : GetCategoriesError()

    data class Network(
        val code: Int = -1,
        val message: String? = null,
        val title: String? = null,
        val isConnectionError: Boolean = false,
    ) : GetCategoriesError() {
        constructor(error: ResultError.NetworkError) : this(
            code = error.code,
            message = error.message,
            title = error.title,
            isConnectionError = error.isConnectionError
        )
    }
}
