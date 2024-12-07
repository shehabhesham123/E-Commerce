package com.example.e_commerce.features.shopping.data.repository

import com.example.e_commerce.core.failure.Failure
import com.example.e_commerce.core.functional.Either
import com.example.e_commerce.core.network.NetworkHandler
import com.example.e_commerce.features.shopping.app.model.Product
import com.example.e_commerce.features.shopping.data.remote.ApiService
import com.example.e_commerce.features.shopping.domain.repository.ProductRepository

class ProductRepositoryImpl(
    private val apiService: ApiService,
    private val networkHandler: NetworkHandler
) : ProductRepository() {
    override suspend fun getAllProducts(): Either<Failure, List<Product>> {
        return if (networkHandler.isNetworkAvailable()) {
            convert(apiService.getAllProducts())
            { response -> response.map { it.toProduct() } }
        } else
            Either.Left(Failure.NetworkFailure)
    }

    private fun <T, R> convert(data: T, transform: (T) -> R): Either<Failure, R> {
        return try {
            Either.Right(transform(data))
        } catch (e: Exception) {
            Either.Left(Failure.ServerFailure)
        }
    }
}