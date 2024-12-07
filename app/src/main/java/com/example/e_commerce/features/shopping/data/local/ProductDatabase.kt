package com.example.e_commerce.features.shopping.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.e_commerce.features.shopping.domain.entity.ProductEntity

@Database(entities = [ProductEntity::class], version = 1)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun dao(): ProductsDao
}