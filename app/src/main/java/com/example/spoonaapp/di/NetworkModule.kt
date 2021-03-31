package com.example.spoonaapp.di

import com.example.spoonaapp.BuildConfig
import com.example.spoonaapp.utils.ConfigApi
import com.example.spoonaapp.utils.QueryApi
import okhttp3.*
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val netWorkModule = module {
    fun initHttpClient(): OkHttpClient {
        val interceptor = object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                val original = chain.request()
                val request = original.newBuilder().url(
                    original.url.newBuilder()
                        .addQueryParameter(QueryApi.API_KEY, BuildConfig.API_KEY)
                        .build()
                ).build()
                return chain.proceed(request)
            }
        }
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    fun initRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ConfigApi.BASE_API)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(client)
            .build()
    }
    single { initHttpClient() }
    single { initRetrofit(get()) }
}
