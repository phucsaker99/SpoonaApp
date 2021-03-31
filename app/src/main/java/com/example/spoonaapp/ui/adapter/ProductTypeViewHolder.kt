package com.example.spoonaapp.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.spoonaapp.databinding.ItemProductTypeBinding

class ProductTypeViewHolder(
    private val binding: ItemProductTypeBinding
) : RecyclerView.ViewHolder(binding.root) {

    private var itemProductType: String? = null

    fun bind(product: String) {
        itemProductType = product
        binding.itemProductType = itemProductType
    }
}
