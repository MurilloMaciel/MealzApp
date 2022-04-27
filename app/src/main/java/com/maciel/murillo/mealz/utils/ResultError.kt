package com.maciel.murillo.mealz.utils

sealed class ResultError(open val message: String?) {
    class NetworkError(
        override val message: String? = null,
        val title: String? = null,
        val isConnectionError: Boolean = false,
        val code: Int = -1,
        val headers: Map<String, List<String>>? = null,
    ) : ResultError(message)

    class UnavailableNetworkConnectionError : ResultError("Connection unavailable")
    class UnauthorizedError : ResultError("User not authorized")
    data class UnknownError(val msg: String? = null) : ResultError(msg ?: "Unknown error")
    class InvalidFieldsError(val fieldIds: List<String>) : ResultError("Invalid fields ($fieldIds)")
}
