package com.example.spoonacularapp.ui.listproduct

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.spoonacularapp.BR
import com.example.spoonacularapp.R
import com.example.spoonacularapp.data.model.Product
import com.example.spoonacularapp.databinding.FragmentListProductBinding
import com.example.spoonacularapp.ui.adapter.ProductAdapter
import com.example.spoonacularapp.utils.showToast
import kotlinx.android.synthetic.main.fragment_list_product.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListProductFragment : Fragment() {
    private val listProductViewModel by viewModel<ListProductViewModel>()
    private var binding: FragmentListProductBinding? = null
    private val args: ListProductFragmentArgs by navArgs()
    private val adapter = ProductAdapter(this::onItemClicked)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = DataBindingUtil.inflate<FragmentListProductBinding>(
        inflater,
        R.layout.fragment_list_product,
        container,
        false
    ).apply {
        binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewProduct.adapter = adapter
        initData()
        initView()
        observeData()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    private fun initData() {
        listProductViewModel.getProduct(args.productType)
    }

    private fun observeData() = listProductViewModel.error.observe(viewLifecycleOwner, Observer {
        context?.showToast(it)
    })

    private fun initView() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            setVariable(BR.listProductVM, listProductViewModel)
        }
    }

    private fun onItemClicked(item: Product) {
        val action =
            ListProductFragmentDirections.actionListProductFragmentToDetailProductFragment(item)
        findNavController().navigate(action)
    }
}
