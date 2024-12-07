package com.example.e_commerce.features.shopping.app.model

import com.example.e_commerce.features.shopping.domain.entity.ProductEntity

data class Product(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    //val rating: Rating,
    val title: String
) {
    fun toProductEntity() = ProductEntity(category, description, id, image, price, title)
}