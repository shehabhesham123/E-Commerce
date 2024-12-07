package com.example.e_commerce.features.shopping.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.e_commerce.features.shopping.app.model.Product

@Entity(tableName = "Products")
data class ProductEntity(
    val category: String,
    val description: String,
    @PrimaryKey
    val id: Int,
    val image: String,
    val price: Double,
    //val rating: Rating,
    val title: String
):BasicEntity {
    fun toProduct() = Product(category, description, id, image, price/*, rating*/, title)
}