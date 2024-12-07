package com.example.e_commerce.features.shopping.domain.repository

import com.example.e_commerce.core.failure.Failure
import com.example.e_commerce.core.functional.Either
import com.example.e_commerce.features.shopping.app.model.Product

abstract class ProductRepository {
    // suspend because this function will call api
    abstract suspend fun getAllProducts(): Either<Failure, List<Product>>
}