package com.example.spoonacularapp.di

import com.example.spoonacularapp.ui.detailproduct.DetailProductViewModel
import com.example.spoonacularapp.ui.listproduct.ListProductViewModel
import com.example.spoonacularapp.ui.searchview.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ListProductViewModel(get()) }
    viewModel { DetailProductViewModel(get()) }
    viewModel { SearchViewModel(get()) }
}
