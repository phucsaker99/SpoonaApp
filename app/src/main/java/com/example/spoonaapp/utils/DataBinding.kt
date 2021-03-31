package com.example.spoonaapp.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.spoonaapp.ui.adapter.UpdateDataAdapter

@BindingAdapter("app:data")
fun <T> setDataRecyclerView(recyclerView: RecyclerView, data: List<T>?) {
    (recyclerView.adapter as UpdateDataAdapter<T>).setData(data)
}

@BindingAdapter("app:image")
fun loadJsonToImage(imageView: ImageView, urlImage: String) {
    imageView.loadImage(urlImage)
}
