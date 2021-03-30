package com.example.spoonacularapp.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.spoonacularapp.R

fun ImageView.loadImage(image: String?) {
    Glide.with(context).load(image)
        .error(R.drawable.ic_error)
        .placeholder(R.drawable.ic_launcher_foreground)
        .into(this)
}
