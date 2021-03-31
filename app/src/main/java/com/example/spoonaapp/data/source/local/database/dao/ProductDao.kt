package com.example.spoonaapp.data.source.local.database.dao

import androidx.room.*
import com.example.spoonaapp.data.model.Product
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface ProductDao {

    @Query("SELECT * FROM ProductTBL")
    fun getFavorites(): Single<List<Product>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavorites(product: Product): Completable

    @Delete
    fun deleteFavorites(product: Product): Completable

    @Query("SELECT * FROM ProductTBL WHERE id =:id")
    fun isFavorite(id: String): Single<List<Product>>
}
