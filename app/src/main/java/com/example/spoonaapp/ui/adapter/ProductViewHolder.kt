package com.example.spoonaapp.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.spoonaapp.data.model.Product
import com.example.spoonaapp.databinding.ItemProductBinding

class ProductViewHolder(
    private val binding: ItemProductBinding
) : RecyclerView.ViewHolder(binding.root) {

    private var itemProduct: Product? = null

    fun bind(product: Product) {
        itemProduct = product
        binding.itemProduct = itemProduct
    }
}
