package com.example.spoonaapp.data.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.spoonaapp.data.model.Product
import com.example.spoonaapp.data.source.local.database.AppDatabase.Companion.DATABASE_VERSION
import com.example.spoonaapp.data.source.local.database.AppDatabase.Companion.EXPORT_SCHEME
import com.example.spoonaapp.data.source.local.database.dao.ProductDao

@Database(
    entities = [Product::class],
    version = DATABASE_VERSION,
    exportSchema = EXPORT_SCHEME
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getProductDao(): ProductDao

    companion object {
        const val DATABASE_VERSION = 5
        const val DATABASE_NAME = "product_database"
        const val EXPORT_SCHEME = false
    }
}
