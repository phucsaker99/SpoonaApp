package com.example.spoonacularapp.ui.detailproduct

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.spoonacularapp.data.model.Product
import com.example.spoonacularapp.data.repository.ProductRepository
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers
import wu.seal.jsontokotlin.feedback.actionInfoUrl

class DetailProductViewModel(
    private val repository: ProductRepository
) : ViewModel() {

    private val disposables = CompositeDisposable()

    private val _product = MutableLiveData<List<Product>>()
    val product: LiveData<List<Product>> get() = _product

    private val _favorite = MutableLiveData<Boolean>()
    val favorite: LiveData<Boolean> get() = _favorite

    private val _error = MutableLiveData<String>()
    val error get() = _error

    private val _success = MutableLiveData<String>()
    val success get() = _success

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }

    fun getFavorite(idProduct: Int) {
        repository.isFavorite(idProduct.toString())
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.computation())
            .subscribe({
                _favorite.postValue(it)
            }, {
                _error.postValue(it.message.toString())
            })
            .addTo(disposables)
    }

    fun insertFavorite(itemProduct: Product) {
        repository.insertFavoriteProduct(itemProduct)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.computation())
            .subscribe({
                _success.postValue(itemProduct.title)
            }, {
                _error.postValue(it.message.toString())
            })
            .addTo(disposables)
    }

    fun deleteFavorite(itemProduct: Product) {
        repository.deleteFavoriteProduct(itemProduct)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.computation())
            .subscribe({
                _success.postValue(actionInfoUrl)
            }, {
                _error.postValue(it.message.toString())
            })
            .addTo(disposables)
    }
}
