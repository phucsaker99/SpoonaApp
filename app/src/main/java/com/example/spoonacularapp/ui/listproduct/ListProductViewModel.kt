package com.example.spoonacularapp.ui.listproduct

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.spoonacularapp.data.model.Product
import com.example.spoonacularapp.data.repository.ProductRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class ListProductViewModel(
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

    fun getProduct(productType: String) {
        repository.getProductByType(productType)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.computation())
            .subscribe({
                _product.postValue(it.products)
            }, {
                _error.postValue(it.message.toString())
            })
            .addTo(disposables)
    }
}
