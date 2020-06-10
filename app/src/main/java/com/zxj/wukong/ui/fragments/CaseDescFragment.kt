package com.zxj.wukong.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zxj.wukong.databinding.FragmentDescBinding

class CaseDescFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentDescBinding.inflate(inflater,container,false).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        FragmentDescBinding.bind(view)
    }
}