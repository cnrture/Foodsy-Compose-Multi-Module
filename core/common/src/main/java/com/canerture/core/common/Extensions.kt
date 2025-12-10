package com.canerture.core.common

fun Int?.orZero() = this ?: 0

fun Double?.orZero() = this ?: 0.0

fun Boolean?.orFalse() = this ?: false

fun <T> Result<T>.toUnit(): Result<Unit> {
    return this.fold(
        onSuccess = { Result.success(Unit) },
        onFailure = { Result.failure(it) },
    )
}