package com.example.spoonacularapp.data.source.local

import com.example.spoonacularapp.data.model.Product
import com.example.spoonacularapp.data.source.ProductDataSource
import com.example.spoonacularapp.data.source.local.database.dao.ProductDao
import io.reactivex.rxjava3.core.Single

class ProductLocalDataSource(
    private val productDao: ProductDao
) : ProductDataSource.Local {

    override fun getFavoriteProduct() = productDao.getFavorites()

    override fun insertFavoriteProduct(product: Product) = productDao.insertFavorites(product)

    override fun deleteFavoriteProduct(product: Product) = productDao.deleteFavorites(product)

    override fun isFavorite(id: String): Single<Boolean> =
        productDao.isFavorite(id).map { it.isNotEmpty() }
}