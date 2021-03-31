package com.example.spoonaapp.data.source.remote.util

import com.example.spoonaapp.data.model.ProductType
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface CallApi {

    @GET("food/products/search")
    fun getProductsByType(
        @Query("query") query: String
    ): Single<ProductType>
}
