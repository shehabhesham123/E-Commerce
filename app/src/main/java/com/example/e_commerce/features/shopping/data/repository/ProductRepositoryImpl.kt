package com.example.e_commerce.features.shopping.data.repository

import com.example.e_commerce.core.failure.Failure
import com.example.e_commerce.core.functional.Either
import com.example.e_commerce.core.network.NetworkHandler
import com.example.e_commerce.features.shopping.app.model.Product
import com.example.e_commerce.features.shopping.data.handler.ProductsLocalHandler
import com.example.e_commerce.features.shopping.domain.repository.ProductRepository
import com.example.e_commerce.features.shopping.domain.repository.handler.Handler

class ProductRepositoryImpl(
    private val productsLocalHandler: ProductsLocalHandler,
) : ProductRepository() {
    override suspend fun getAllProducts(): Either<Failure, List<Product>> {
        return productsLocalHandler.handle(Handler.None)
    }
}