package com.example.e_commerce.features.shopping.data.handler

import android.util.Log
import com.example.e_commerce.core.failure.Failure
import com.example.e_commerce.core.functional.Either
import com.example.e_commerce.features.shopping.app.model.Product
import com.example.e_commerce.features.shopping.data.local.ProductDatabase
import com.example.e_commerce.features.shopping.domain.repository.handler.Handler

private const val TAG = "Handler"

class ProductsLocalHandler(
    private val database: ProductDatabase,
    remoteHandler: Handler<None, List<Product>>
) : Handler<Handler.None, List<Product>>(remoteHandler) {

    override suspend fun handle(params: None): Either<Failure, List<Product>> {
        Log.d(TAG, "handle: (ProductsLocalHandler)")
        try {
            val products = database.dao().getAllProducts()
            if (products.isNotEmpty()) {
                convert(products) { response -> response.map { it.toProduct() } }.apply {
                    if (isRight)
                        return this
                }
            }
            return successor!!.handle(params)   // if end of chain will throw exception and then will catch it and return failure
        } catch (e: Exception) {
            return Either.Left(Failure.UnknownFailure)
        }
    }
}