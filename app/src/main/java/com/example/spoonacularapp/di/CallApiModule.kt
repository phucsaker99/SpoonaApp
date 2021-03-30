package com.example.spoonacularapp.di

import com.example.spoonacularapp.data.source.remote.util.CallApi
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single { get<Retrofit>().create(CallApi::class.java) }
}
