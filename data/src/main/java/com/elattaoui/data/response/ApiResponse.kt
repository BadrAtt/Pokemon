package com.elattaoui.data.response

sealed class ApiResponse<T : Any> {
    class Success<T : Any>(val data: T) : ApiResponse<T>()
    class Error<T : Any>(val code: Int = -1, val exception: Throwable) : ApiResponse<T>()
}