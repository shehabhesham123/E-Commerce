package com.example.e_commerce.features.shopping.data.handler

import com.example.e_commerce.features.shopping.data.local.ProductDatabase
import com.example.e_commerce.features.shopping.domain.entity.ProductEntity

class ProductsCache(private val database: ProductDatabase) {
    suspend fun cache(params: List<ProductEntity>) {
        database.dao().insertProducts(params)
    }
}