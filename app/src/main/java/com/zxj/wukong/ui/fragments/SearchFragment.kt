package com.zxj.wukong.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import com.zxj.wukong.adapter.ShoppingCartAdapter
import com.zxj.wukong.databinding.FragmentSearchBinding
import com.zxj.wukong.repository.local.DbManager
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class SearchFragment:Fragment() {
    lateinit var bind:FragmentSearchBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentSearchBinding.inflate(inflater).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind = FragmentSearchBinding.bind(view)
        val shoppingCartAdapter = ShoppingCartAdapter(emptyList())
        bind.rv.adapter = shoppingCartAdapter
        bind.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText.isNullOrEmpty()){
                    shoppingCartAdapter.casesInfo = listOf()
                }else{
                    GlobalScope.launch {
                        val queryByKeyWord = DbManager.casesDao.queryByKeyWord(newText)
                        shoppingCartAdapter.casesInfo = queryByKeyWord
                        MainScope().launch {
                            shoppingCartAdapter.notifyDataSetChanged()
                        }
                    }
                }
                return false
            }
        })
    }
}