package com.elattaoui.data.response

import com.elattaoui.data.mapper.Mapper
import com.elattaoui.domain.model.resource.ResultState
import retrofit2.HttpException
import retrofit2.Response

suspend fun <Entity, Domain> handleApiReponse(
    mapper: Mapper<Entity, Domain>,
    execute: suspend () -> Response<Entity>,
): ResultState<Domain> {
    return try {
        val response = execute()
        val body = response.body()
        if (response.isSuccessful && body != null) {
            ResultState.Success(mapper.map(body))
        } else {
            ResultState.Error(code = response.code(), exception = Throwable(response.message()))
        }
    } catch (e: HttpException) {
        ResultState.Error(code = e.code(), exception = Throwable(e.message()))
    } catch (e: Throwable) {
        ResultState.Error(exception = e)
    }
}