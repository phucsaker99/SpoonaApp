package com.example.spoonacularapp.ui.searchview

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.spoonacularapp.BR
import com.example.spoonacularapp.R
import com.example.spoonacularapp.data.model.Product
import com.example.spoonacularapp.databinding.FragmentSearchBinding
import com.example.spoonacularapp.ui.adapter.ProductAdapter
import com.example.spoonacularapp.ui.detailproduct.DetailProductViewModel
import com.example.spoonacularapp.utils.showToast
import kotlinx.android.synthetic.main.fragment_list_product.*
import kotlinx.android.synthetic.main.fragment_search.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : Fragment() {
    private var binding: FragmentSearchBinding? = null
    private val searchViewModel by viewModel<SearchViewModel>()
    private val adapter = ProductAdapter(this::onItemClicked)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = DataBindingUtil.inflate<FragmentSearchBinding>(
        inflater,
        R.layout.fragment_search, container, false
    ).apply {
        binding = this
    }.root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerFavoriteProduct.adapter = adapter
        initToolbar()
        initView()
        observeData()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_search, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.text_menu_search -> {
                checkSearchView(item)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initView() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            setVariable(BR.SearchVM, searchViewModel)
        }
    }

    private fun initToolbar() {
        setHasOptionsMenu(true)
    }

    private fun observeData() {
        searchViewModel.error.observe(viewLifecycleOwner, Observer {
            context?.showToast(it)
        })
    }

    private fun onItemClicked(itemProduct: Product) {
        val action =
            SearchFragmentDirections.actionSearchFragmentToDetailProductFragment(itemProduct)
        findNavController().navigate(action)
    }

    private fun checkSearchView(item: MenuItem) {
        val searchView = item.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let { searchViewModel.filterProduct(it) }
                return true
            }
        })
    }
}
