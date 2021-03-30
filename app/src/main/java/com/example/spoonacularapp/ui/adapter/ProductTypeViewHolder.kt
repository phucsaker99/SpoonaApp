package com.example.spoonacularapp.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.spoonacularapp.data.model.Product
import com.example.spoonacularapp.databinding.ItemProductBinding
import com.example.spoonacularapp.databinding.ItemProductTypeBinding

class ProductTypeViewHolder(
    private val binding: ItemProductTypeBinding,
    onItemClicked: (String) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    private var itemProductType: String? = null

    init {
        binding.root.setOnClickListener {
            itemProductType?.let { onItemClicked(it) }
        }
    }

    fun bind(product: String) {
        itemProductType = product
        binding.itemProductType = itemProductType
    }
}
