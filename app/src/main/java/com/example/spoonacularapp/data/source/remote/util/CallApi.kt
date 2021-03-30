package com.example.spoonacularapp.data.source.remote.util

import com.example.spoonacularapp.BuildConfig
import com.example.spoonacularapp.data.model.Product
import com.example.spoonacularapp.data.model.ProductType
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface CallApi {

    @GET("food/products/search")
    fun getProductByType(
        @Query("query") query: String,
        @Query("number") number: Int = 5,
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY
    ): Observable<ProductType>
}