package com.example.spoonacularapp.ui.homefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.spoonacularapp.R
import com.example.spoonacularapp.databinding.FragmentHomeBinding
import com.example.spoonacularapp.ui.adapter.ProductTypeAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    private var binding: FragmentHomeBinding? = null
    private var adapterProductType = ProductTypeAdapter(this::onItemClicked)

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
        val productType = resources.getStringArray(R.array.list_product)
        adapterProductType.setData(productType)
    }

    private fun onItemClicked(product: String) {
        val action = HomeFragmentDirections.actionHomeFragmentToListProductFragment(product)
        findNavController().navigate(action)
    }
}
