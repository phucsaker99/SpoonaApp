package com.example.spoonaapp.di

import com.example.spoonaapp.data.source.remote.util.CallApi
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single { get<Retrofit>().create(CallApi::class.java) }
}
