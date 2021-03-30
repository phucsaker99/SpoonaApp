package com.example.spoonacularapp.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.spoonacularapp.ui.adapter.UpdateDataAdapter

@BindingAdapter("data")
fun <T> setDataRecyclerView(recyclerView: RecyclerView, data: List<T>?) {
    (recyclerView.adapter as UpdateDataAdapter<T>).setData(data)
}

@BindingAdapter("image")
fun loadJsonToImage(imageView: ImageView, urlImage: String) {
    imageView.loadImage(urlImage)
}
