package com.example.spoonaapp.di

import androidx.room.Room
import com.example.spoonaapp.data.repository.ProductRepository
import com.example.spoonaapp.data.repository.ProductRepositoryImp
import com.example.spoonaapp.data.source.ProductDataSource
import com.example.spoonaapp.data.source.local.ProductLocalDataSource
import com.example.spoonaapp.data.source.local.database.AppDatabase
import com.example.spoonaapp.data.source.local.database.AppDatabase.Companion.DATABASE_NAME
import com.example.spoonaapp.data.source.remote.ProductRemoteDataSource
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
