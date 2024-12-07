package com.example.e_commerce.features.shopping.app.di

import com.example.e_commerce.features.shopping.domain.interactor.GetAllProducts
import com.example.e_commerce.features.shopping.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UsecaseModule {
    @Provides
    fun provideGetAllProducts(productsRepository: ProductRepository): GetAllProducts {
        return GetAllProducts(productsRepository)
    }
}