package com.example.spoonacularapp.ui.searchview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.spoonacularapp.data.model.Product
import com.example.spoonacularapp.data.repository.ProductRepository
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*

class SearchViewModel(
    private val repository: ProductRepository
) : ViewModel() {

    private val disposables = CompositeDisposable()

    private val _product = MutableLiveData<List<Product>>()
    val product: LiveData<List<Product>> get() = _product

    private val _error = MutableLiveData<String>()
    val error get() = _error

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }

    init {
        getFavoriteProduct()
    }

    private fun getFavoriteProduct() {
        repository.getFavoriteProduct()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.computation())
            .subscribe({
                _product.postValue(it)
            }, {
                _error.postValue(it.message.toString())
            })
            .addTo(disposables)
    }

    fun filterProduct(keyWord: String) {
        if (keyWord.isEmpty()) {
            getFavoriteProduct()
            return
        }
        repository.getFavoriteProduct()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.computation())
            .subscribe({
                _product.postValue(it.filter { its ->
                    its.title.toLowerCase(Locale.ROOT).contains(keyWord)
                })
            }, {
                _error.postValue(it.message.toString())
            })
            .addTo(disposables)
    }
}
