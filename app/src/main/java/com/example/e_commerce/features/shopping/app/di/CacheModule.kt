package com.example.e_commerce.features.shopping.app.di

import android.content.Context
import androidx.room.Room
import com.example.e_commerce.features.shopping.data.handler.ProductsCache
import com.example.e_commerce.features.shopping.data.local.ProductDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {
    @Provides
    @Singleton
    fun provideCache(@ApplicationContext context: Context): ProductDatabase {
        return Room.databaseBuilder(context, ProductDatabase::class.java, "product_db").build()
    }

    @Provides
    @Singleton
    fun providesProductsCache(database: ProductDatabase): ProductsCache {
        return ProductsCache(database)
    }

}