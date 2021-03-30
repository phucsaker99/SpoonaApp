package com.example.spoonacularapp.di

import androidx.room.Room
import com.example.spoonacularapp.data.repository.ProductRepository
import com.example.spoonacularapp.data.repository.ProductRepositoryImp
import com.example.spoonacularapp.data.source.ProductDataSource
import com.example.spoonacularapp.data.source.local.ProductLocalDataSource
import com.example.spoonacularapp.data.source.local.database.AppDatabase
import com.example.spoonacularapp.data.source.local.database.AppDatabase.Companion.DATABASE_NAME
import com.example.spoonacularapp.data.source.remote.ProductRemoteDataSource
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dbModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            DATABASE_NAME
        ).build()
    }
    single { get<AppDatabase>().getProductDao() }
}

val repoProductModule = module {
    single<ProductDataSource.Remote> { ProductRemoteDataSource(get()) }
    single<ProductDataSource.Local> { ProductLocalDataSource(get()) }
    single<ProductRepository> { ProductRepositoryImp(get(), get()) }
}
