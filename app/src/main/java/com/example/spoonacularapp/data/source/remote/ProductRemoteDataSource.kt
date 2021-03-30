package com.example.spoonacularapp.data.source.remote

import com.example.spoonacularapp.data.model.Product
import com.example.spoonacularapp.data.model.ProductType
import com.example.spoonacularapp.data.source.ProductDataSource
import com.example.spoonacularapp.data.source.remote.util.CallApi
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.kotlin.cast

class ProductRemoteDataSource(
    private val callApi: CallApi
) : ProductDataSource.Remote {

    override fun getProductByType(productType: String): Observable<ProductType> =
        callApi.getProductByType(productType)
}
