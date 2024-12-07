package com.example.e_commerce.features.shopping.data.handler

import com.example.e_commerce.core.failure.Failure
import com.example.e_commerce.core.functional.Either
import com.example.e_commerce.core.network.NetworkHandler
import com.example.e_commerce.features.shopping.app.model.Product
import com.example.e_commerce.features.shopping.data.remote.ApiService
import com.example.e_commerce.features.shopping.domain.repository.handler.Handler

class ProductsRemoteHandler(
    private val apiService: ApiService,
    private val productsCache: ProductsCache,
    private val networkHandler: NetworkHandler
) :
    Handler<Handler.None, List<Product>>(null) {
    override suspend fun handle(params: None): Either<Failure, List<Product>> {
        return if (networkHandler.isNetworkAvailable()) {
            try {
                convert(
                    apiService.getAllProducts().apply { productsCache.cache(this) }) { response ->
                    response.map { it.toProduct() }
                }
            } catch (e: Exception) {
                Either.Left(Failure.ServerFailure)
            }
        } else {
            Either.Left(Failure.NetworkFailure)
        }
    }
}