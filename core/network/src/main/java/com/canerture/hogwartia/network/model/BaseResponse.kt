package com.canerture.hogwartia.network.model

import kotlinx.serialization.Serializable

@Serializable
open class BaseResponse<T>(
    val data: T? = null,
    val message: String? = null,
)