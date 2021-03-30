package com.example.spoonacularapp.data.repository

import com.example.spoonacularapp.data.model.Product
import com.example.spoonacularapp.data.model.ProductType
import com.example.spoonacularapp.data.source.ProductDataSource
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

class ProductRepositoryImp(
    private val local: ProductDataSource.Local,
    private val remote: ProductDataSource.Remote
) : ProductRepository {

    override fun getProductByType(productType: String): Observable<ProductType> =
        remote.getProductByType(productType)

    override fun getFavoriteProduct() = local.getFavoriteProduct()

    override fun insertFavoriteProduct(product: Product) = local.insertFavoriteProduct(product)

    override fun deleteFavoriteProduct(product: Product) = local.deleteFavoriteProduct(product)

    override fun isFavorite(id: String): Single<Boolean> = local.isFavorite(id)
}
