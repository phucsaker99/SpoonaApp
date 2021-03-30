package com.example.spoonacularapp.ui.detailproduct

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.spoonacularapp.BR
import com.example.spoonacularapp.R
import com.example.spoonacularapp.data.model.Product
import com.example.spoonacularapp.databinding.FragmentDetailProductBinding
import com.example.spoonacularapp.utils.showToast
import kotlinx.android.synthetic.main.fragment_detail_product.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailProductFragment : Fragment() {
    private val detailProductViewModel by viewModel<DetailProductViewModel>()
    private var binding: FragmentDetailProductBinding? = null
    private val args: DetailProductFragmentArgs by navArgs()
    private var itemProduct: Product? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = DataBindingUtil.inflate<FragmentDetailProductBinding>(
        inflater,
        R.layout.fragment_detail_product,
        container,
        false
    ).apply {
        binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observerData()
        initAction()
    }

    override fun onPause() {
        if (imageFavorite.visibility == View.VISIBLE) {
            itemProduct?.let { detailProductViewModel.insertFavorite(it) }
        } else {
            itemProduct?.let { detailProductViewModel.deleteFavorite(it) }
        }
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    private fun initView() {
        itemProduct = args.itemProduct
        itemProduct?.let {
            detailProductViewModel.getFavorite(it.id)
        }
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            setVariable(BR.itemProduct, args.itemProduct)
        }
    }

    private fun observerData() {
        detailProductViewModel.apply {
            error.observe(viewLifecycleOwner, Observer {
                context?.showToast(it)
            })
            success.observe(viewLifecycleOwner, Observer {
                context?.showToast(String.format(resources.getString(R.string.text_home), it))
            })
            favorite.observe(viewLifecycleOwner, Observer {
                if (it) {
                    checkFavorite(true)
                } else {
                    checkFavorite(false)
                }
            })
        }
    }

    private fun initAction() {
        imageUnFavorite.setOnClickListener {
            checkFavorite(true)
        }
        imageFavorite.setOnClickListener {
            checkFavorite(false)
        }
    }

    private fun checkFavorite(choose: Boolean) {
        if (choose) {
            imageUnFavorite.visibility = View.GONE
            imageFavorite.visibility = View.VISIBLE
        } else {
            imageUnFavorite.visibility = View.VISIBLE
            imageFavorite.visibility = View.GONE
        }
    }
}
