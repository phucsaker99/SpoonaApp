package com.example.spoonaapp.data.model

import com.google.gson.annotations.SerializedName

class ProductType {
    @SerializedName("products")
    val products = mutableListOf<Product>()
}
