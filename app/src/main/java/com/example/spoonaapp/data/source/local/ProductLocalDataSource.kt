package com.example.spoonaapp.data.source.local

import com.example.spoonaapp.data.model.Product
import com.example.spoonaapp.data.source.ProductDataSource
import com.example.spoonaapp.data.source.local.database.dao.ProductDao
import io.reactivex.rxjava3.core.Single

class ProductLocalDataSource(
    private val productDao: ProductDao
) : ProductDataSource.Local {

    override fun getFavoriteProducts() = productDao.getFavorites()

    override fun insertFavoriteProduct(product: Product) = productDao.insertFavorites(product)

    override fun deleteFavoriteProduct(product: Product) = productDao.deleteFavorites(product)

    override fun isFavorite(id: String): Single<Boolean> =
        productDao.isFavorite(id).map { it.isNotEmpty() }
}
