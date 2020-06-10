package com.zxj.wukong.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.zxj.base.net.NetResult
import com.zxj.wukong.adapter.CasesAdapter
import com.zxj.wukong.data.CaseInfo
import com.zxj.wukong.databinding.FragmentHomeBinding
import com.zxj.wukong.viewmodels.CasesInfoViewModel

class HomeFragment:Fragment() {
    lateinit var adapter:CasesAdapter
    lateinit var bindView:FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentHomeBinding.inflate(LayoutInflater.from(context)).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindView = FragmentHomeBinding.bind(view)
        val model: CasesInfoViewModel by viewModels()
        model.casesInfo.observe(viewLifecycleOwner,
            Observer<NetResult<List<CaseInfo>>> {
                if (it.result != null){
                    adapter = CasesAdapter(it.result)
                    bindView.rv.adapter = adapter
                }

            })
    }

}


