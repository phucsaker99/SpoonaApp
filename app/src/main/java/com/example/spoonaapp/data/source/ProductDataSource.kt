package com.example.spoonaapp.data.source

import com.example.spoonaapp.data.model.Product
import com.example.spoonaapp.data.model.ProductType
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface ProductDataSource {
    interface Remote {
        fun getProductsByType(productType: String): Single<ProductType>
    }

    interface Local {
        fun getFavoriteProducts(): Single<List<Product>>
        fun insertFavoriteProduct(product: Product): Completable
        fun deleteFavoriteProduct(product: Product): Completable
        fun isFavorite(id: String): Single<Boolean>
    }
}
