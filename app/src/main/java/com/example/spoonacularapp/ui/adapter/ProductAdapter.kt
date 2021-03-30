package com.example.spoonacularapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.spoonacularapp.R
import com.example.spoonacularapp.data.model.Product

class ProductAdapter(private val onItemClicked: (Product) -> Unit) :
    ListAdapter<Product, ProductViewHolder>(Product.diffUtil), UpdateDataAdapter<Product> {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.item_product, parent, false
            ), onItemClicked
        )
    }

    override fun onBindViewHolder(holderType: ProductViewHolder, position: Int) {
        holderType.bind(getItem(position))
    }

    override fun setData(data: List<Product>?) {
        submitList(data)
    }
}
