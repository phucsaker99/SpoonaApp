package com.example.spoonaapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.spoonaapp.R
import com.example.spoonaapp.data.model.Product

class ProductAdapter : ListAdapter<Product, ProductViewHolder>(Product.diffUtil),
    UpdateDataAdapter<Product> {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ProductViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.item_product, parent, false
            )
        )

    override fun onBindViewHolder(holderType: ProductViewHolder, position: Int) =
        holderType.bind(getItem(position))

    override fun setData(data: List<Product>?) {
        submitList(data)
    }
}
