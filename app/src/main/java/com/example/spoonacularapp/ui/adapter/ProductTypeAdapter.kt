package com.example.spoonacularapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.spoonacularapp.R

class ProductTypeAdapter(private val onItemClicked: (String) -> Unit) :
    RecyclerView.Adapter<ProductTypeViewHolder>() {
    private val products = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductTypeViewHolder {
        return ProductTypeViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.item_product_type, parent, false
            ), onItemClicked
        )
    }

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
}
