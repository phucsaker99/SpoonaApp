package com.example.spoonacularapp

import android.app.Application
import com.example.spoonacularapp.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(
                listOf(
                    netWorkModule,
                    apiModule,
                    repoProductModule,
                    viewModelModule,
                    dbModule
                )
            )
        }
    }
}
