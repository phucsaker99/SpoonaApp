package com.example.spoonaapp.data.source.remote

import com.example.spoonaapp.data.model.ProductType
import com.example.spoonaapp.data.source.ProductDataSource
import com.example.spoonaapp.data.source.remote.util.CallApi
import io.reactivex.rxjava3.core.Single

class ProductRemoteDataSource(
    private val callApi: CallApi
) : ProductDataSource.Remote {

    override fun getProductsByType(productType: String): Single<ProductType> =
        callApi.getProductsByType(productType)
}
