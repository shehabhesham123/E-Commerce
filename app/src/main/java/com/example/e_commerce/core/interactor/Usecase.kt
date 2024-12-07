package com.example.e_commerce.core.interactor

import com.example.e_commerce.core.failure.Failure
import com.example.e_commerce.core.functional.Either

abstract class Usecase<in Params, out Type : Any /* not null */> {
    abstract suspend fun run(params: Params): Either<Failure, Type>

    suspend operator fun invoke(params: Params): Either<Failure, Type> {
        return run(params)
    }

    // for usecase without params
    object None
}