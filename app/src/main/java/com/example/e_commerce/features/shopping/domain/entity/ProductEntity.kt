package com.example.e_commerce.features.shopping.domain.entity

import com.example.e_commerce.features.shopping.app.model.Product

data class ProductEntity(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
) {
    fun toProduct() = Product(category, description, id, image, price, rating, title)
}