package com.example.spoonaapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.spoonaapp.R

class ProductTypeAdapter : ListAdapter<String, ProductTypeViewHolder>(DiffProductType()) {

    private val products = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductTypeViewHolder =
        ProductTypeViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.item_product_type, parent, false
            )
        )

    override fun getItemCount() = products.size

    override fun onBindViewHolder(holderType: ProductTypeViewHolder, position: Int) {
        holderType.bind(products[position])
    }

    fun setData(newProducts: Array<String>) {
        products.run {
            clear()
            addAll(newProducts)
            notifyDataSetChanged()
        }
    }

    class DiffProductType : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String) = oldItem === newItem

        override fun areContentsTheSame(oldItem: String, newItem: String) = oldItem == newItem
    }
}
