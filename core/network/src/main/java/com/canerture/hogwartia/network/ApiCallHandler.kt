package com.canerture.hogwartia.network

import com.canerture.hogwartia.common.AuthorizationException
import com.canerture.hogwartia.common.BadRequestException
import com.canerture.hogwartia.common.NetworkException
import com.canerture.hogwartia.common.NotFoundException
import com.canerture.hogwartia.common.UnknownException
import com.canerture.hogwartia.network.model.BaseResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiCallHandler @Inject internal constructor() {
    suspend operator fun <T : Any> invoke(apiToBeCalled: suspend () -> BaseResponse<T>): Result<BaseResponse<T>> {
        return withContext(Dispatchers.IO) {
            try {
                val response: BaseResponse<T> = apiToBeCalled()
                Result.success(response)
            } catch (e: HttpException) {
                try {
                    val message = Json.parseToJsonElement(
                        e.response()?.errorBody()?.string().orEmpty()
                    ).jsonObject["message"]?.jsonPrimitive?.content.orEmpty().ifEmpty {
                        "An unknown error occurred, please try again later."
                    }

                    when (e.code()) {
                        400 -> Result.failure(BadRequestException(message))
                        401 -> Result.failure(AuthorizationException(message))
                        404 -> Result.failure(NotFoundException(message))
                        else -> Result.failure(UnknownException(message))
                    }
                } catch (_: Exception) {
                    Result.failure(UnknownException("An unknown error occurred, please try again later."))
                }
            } catch (e: IOException) {
                Result.failure(NetworkException(e.message.orEmpty()))
            }
        }
    }
}