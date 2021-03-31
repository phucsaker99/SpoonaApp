package com.example.spoonaapp.data.repository

import com.example.spoonaapp.data.model.Product
import com.example.spoonaapp.data.model.ProductType
import com.example.spoonaapp.data.source.ProductDataSource
import io.reactivex.rxjava3.core.Single

class ProductRepositoryImp(
    private val local: ProductDataSource.Local,
    private val remote: ProductDataSource.Remote
) : ProductRepository {

    override fun getProductsByType(productType: String): Single<ProductType> =
        remote.getProductsByType(productType)

    override fun getFavoriteProducts() = local.getFavoriteProducts()

    override fun insertFavoriteProduct(product: Product) = local.insertFavoriteProduct(product)

    override fun deleteFavoriteProduct(product: Product) = local.deleteFavoriteProduct(product)

    override fun isFavorite(id: String): Single<Boolean> = local.isFavorite(id)
}
