package com.maciel.murillo.mealz.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import okhttp3.internal.http2.ConnectionShutdownException
import retrofit2.HttpException
import retrofit2.Response
import java.net.ConnectException
import java.net.UnknownHostException

private fun Throwable.isConnectionException(): Boolean =
    this is ConnectException || this is UnknownHostException || this is ConnectionShutdownException

suspend fun <T> safeApiCall(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    apiCall: suspend () -> T,
): Result<T, ResultError.NetworkError> {
    return withContext(dispatcher) {
        try {
            mapResponse(apiCall())
        } catch (exception: Exception) {
            if (exception is HttpException) {
                mapHttpExceptionToResultError(
                    exception.response()?.errorBody(),
                    exception.code(),
                    exception.message()
                )
            } else {
                mapGenericExceptionToResultError(exception)
            }
        }
    }
}

private fun <T> mapResponse(response: T): Result<T, ResultError.NetworkError> {
    return if (response !is Response<*>) {
        Result.Success(response)
    } else {
        if (response.isSuccessful) {
            Result.Success(response)
        } else {
            mapHttpExceptionToResultError(
                response.errorBody(),
                response.code(),
                response.message()
            )
        }
    }
}

private fun mapGenericExceptionToResultError(
    exception: Exception,
) = Result.Error(
    ResultError.NetworkError(
        title = exception::class.simpleName,
        message = exception.message,
        isConnectionError = exception.isConnectionException()
    )
)

private fun mapHttpExceptionToResultError(
    errorBody: ResponseBody?,
    statusCode: Int,
    message: String,
) = try {
    Result.Error(
        ResultError.NetworkError(
            code = statusCode,
            message = message,
            isConnectionError = false
        )
    )
} catch (exception: Exception) {
    mapGenericExceptionToResultError(exception)
}