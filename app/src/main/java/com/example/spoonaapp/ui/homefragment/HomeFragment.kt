package com.example.spoonaapp.ui.homefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.spoonaapp.R
import com.example.spoonaapp.databinding.FragmentHomeBinding
import com.example.spoonaapp.ui.adapter.ProductTypeAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    private var binding: FragmentHomeBinding? = null
    private var adapterProductType = ProductTypeAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = DataBindingUtil.inflate<FragmentHomeBinding>(
        inflater,
        R.layout.fragment_home,
        container,
        false
    ).apply {
        binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        recyclerViewProductType.adapter = adapterProductType
        val productType = resources.getStringArray(R.array.list_products)
        adapterProductType.setData(productType)
    }
}
