package com.example.e_commerce.features.shopping.app.di

import com.example.e_commerce.core.network.NetworkHandler
import com.example.e_commerce.features.shopping.data.remote.ApiService
import com.example.e_commerce.features.shopping.data.repository.ProductRepositoryImpl
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
        apiService: ApiService,
        networkHandler: NetworkHandler
    ): ProductRepository {
        return ProductRepositoryImpl(apiService, networkHandler)
    }
}