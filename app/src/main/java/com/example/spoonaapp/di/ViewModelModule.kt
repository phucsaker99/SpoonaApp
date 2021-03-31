package com.example.spoonaapp.di

import com.example.spoonaapp.ui.searchview.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SearchViewModel(get()) }
}
