package com.example.spoonacularapp.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.spoonacularapp.data.model.Product
import com.example.spoonacularapp.databinding.ItemProductBinding

class ProductViewHolder(
    private val binding: ItemProductBinding,
    onItemClicked: (Product) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    private var itemProduct: Product? = null

    init {
        binding.root.setOnClickListener {
            itemProduct?.let(onItemClicked)
        }
    }

    fun bind(product: Product) {
        itemProduct = product
        binding.itemProduct = itemProduct
    }
}
