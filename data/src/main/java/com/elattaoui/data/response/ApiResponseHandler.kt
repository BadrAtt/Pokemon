package com.elattaoui.data.response

import retrofit2.HttpException
import retrofit2.Response

suspend fun <T : Any> handleApiReponse(
    execute: suspend () -> Response<T>
): ApiResponse<T> {
    return try {
        val response = execute()
        val body = response.body()
        if (response.isSuccessful && body != null) {
            ApiResponse.Success(body)
        } else {
            ApiResponse.Error(code = response.code(), exception = Throwable(response.message()))
        }
    } catch (e: HttpException) {
        ApiResponse.Error(code = e.code(), exception = Throwable(e.message()))
    } catch (e: Throwable) {
        ApiResponse.Error(exception = e)
    }
}