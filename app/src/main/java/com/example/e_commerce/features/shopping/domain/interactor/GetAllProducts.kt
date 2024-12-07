package com.example.e_commerce.features.shopping.domain.interactor

import com.example.e_commerce.core.failure.Failure
import com.example.e_commerce.core.functional.Either
import com.example.e_commerce.core.interactor.Usecase
import com.example.e_commerce.features.shopping.app.model.Product
import com.example.e_commerce.features.shopping.domain.repository.ProductRepository

class GetAllProducts(private val productRepository: ProductRepository) :
    Usecase<Usecase.None, List<Product>>() {
    override suspend fun run(params: None): Either<Failure, List<Product>> {
        // get product by repo
        return productRepository.getAllProducts()
    }
}