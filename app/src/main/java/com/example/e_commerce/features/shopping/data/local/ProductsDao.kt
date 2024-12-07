package com.example.e_commerce.features.shopping.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.e_commerce.features.shopping.domain.entity.ProductEntity

@Dao
interface ProductsDao {
    @Query("SELECT * FROM products")
    suspend fun getAllProducts(): List<ProductEntity>

    @Insert
    suspend fun insertProduct(product: ProductEntity)

    @Insert
    suspend fun insertProducts(products: List<ProductEntity>)

}