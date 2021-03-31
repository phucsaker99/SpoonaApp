package com.example.spoonaapp.ui.searchview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.spoonaapp.data.model.Product
import com.example.spoonaapp.data.repository.ProductRepository
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
    val error: LiveData<String> get() = _error

    init {
        getFavoriteProduct()
    }

    fun filterProduct(keyWord: String) {
        if (keyWord.isEmpty()) {
            getFavoriteProduct()
            return
        }
        repository.getFavoriteProducts()
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

    private fun getFavoriteProduct() {
        repository.getFavoriteProducts()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.computation())
            .subscribe({
                _product.postValue(it)
            }, {
                _error.postValue(it.message.toString())
            })
            .addTo(disposables)
    }

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }
}
