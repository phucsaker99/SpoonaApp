package com.example.spoonaapp.data.repository

import com.example.spoonaapp.data.model.Product
import com.example.spoonaapp.data.model.ProductType
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface ProductRepository {
    fun getProductsByType(productType: String): Single<ProductType>
    fun getFavoriteProducts(): Single<List<Product>>
    fun insertFavoriteProduct(product: Product): Completable
    fun deleteFavoriteProduct(product: Product): Completable
    fun isFavorite(id: String): Single<Boolean>
}
