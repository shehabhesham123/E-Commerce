package com.example.e_commerce.features.shopping.domain.repository.handler

import com.example.e_commerce.core.failure.Failure
import com.example.e_commerce.core.functional.Either

abstract class Handler<in Params, out Type : Any>(
    protected val successor: Handler<Params, Type>?
) {
    abstract suspend fun handle(params: Params): Either<Failure, Type>

    protected fun <T, R> convert(data: T, transform: (T) -> R): Either<Failure, R> {
        return try {
            Either.Right(transform(data))
        } catch (e: Exception) {
            Either.Left(Failure.ServerFailure)
        }
    }

    object None
}