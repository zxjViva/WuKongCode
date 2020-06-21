package com.zxj.wukong.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zxj.wukong.adapter.ShoppingCartAdapter
import com.zxj.wukong.databinding.FragmentShoppingcartBinding
import com.zxj.wukong.repository.local.DbManager
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ShoppingCarFragment : Fragment() {
    lateinit var binding: FragmentShoppingcartBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShoppingcartBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        GlobalScope.launch {
            val casesInfo = DbManager.shoppingCartDao.queryAll()
            activity?.runOnUiThread {
                val shoppingCartAdapter = ShoppingCartAdapter(casesInfo)
                binding.rv.adapter = shoppingCartAdapter
            }
        }

    }
}