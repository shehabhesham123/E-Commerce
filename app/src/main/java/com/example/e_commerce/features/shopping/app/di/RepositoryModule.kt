package com.example.e_commerce.features.shopping.app.di

import com.example.e_commerce.core.network.NetworkHandler
import com.example.e_commerce.features.shopping.data.handler.ProductsCache
import com.example.e_commerce.features.shopping.data.handler.ProductsLocalHandler
import com.example.e_commerce.features.shopping.data.handler.ProductsRemoteHandler
import com.example.e_commerce.features.shopping.data.local.ProductDatabase
import com.example.e_commerce.features.shopping.data.remote.ApiService
import com.example.e_commerce.features.shopping.data.repository.ProductRepositoryImpl
import com.example.e_commerce.features.shopping.domain.entity.BasicEntity
import com.example.e_commerce.features.shopping.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideRepository(
        productsLocalHandler: ProductsLocalHandler
    ): ProductRepository {
        return ProductRepositoryImpl(productsLocalHandler)
    }

    @Provides
    fun provideLocalHandler(
        database: ProductDatabase,
        productsRemoteHandler: ProductsRemoteHandler
    ): ProductsLocalHandler {
        return ProductsLocalHandler(database, productsRemoteHandler)
    }

    @Provides
    fun providesRemoteHandler(
        apiService: ApiService,
        productsCache: ProductsCache,
        networkHandler: NetworkHandler
    ): ProductsRemoteHandler {
        return ProductsRemoteHandler(apiService, productsCache, networkHandler)
    }


}