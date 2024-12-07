package com.example.e_commerce.features.shopping.data.remote

import com.example.e_commerce.features.shopping.domain.entity.ProductsResponse
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getAllProducts(): ProductsResponse
}