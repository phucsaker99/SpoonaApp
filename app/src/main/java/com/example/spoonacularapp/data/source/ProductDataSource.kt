package com.example.spoonacularapp.data.source

import com.example.spoonacularapp.data.model.Product
import com.example.spoonacularapp.data.model.ProductType
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface ProductDataSource {
    interface Remote {
        fun getProductByType(productType: String): Observable<ProductType>
    }

    interface Local {
        fun getFavoriteProduct(): Observable<List<Product>>
        fun insertFavoriteProduct(product: Product): Completable
        fun deleteFavoriteProduct(product: Product): Completable
        fun isFavorite(id: String): Single<Boolean>
    }
}