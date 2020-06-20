package com.zxj.wukong.ui.fragments

import android.graphics.Path
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.github.florent37.viewanimator.ViewAnimator
import com.zxj.base.net.NetResult
import com.zxj.wukong.R
import com.zxj.wukong.adapter.CasesAdapter
import com.zxj.wukong.data.CaseInfo
import com.zxj.wukong.databinding.FragmentHomeBinding
import com.zxj.wukong.databinding.HomeHeaderLayoutBinding
import com.zxj.wukong.viewmodels.CasesInfoViewModel

class HomeFragment : Fragment() {
    private lateinit var adapter: CasesAdapter
    private lateinit var bindView: FragmentHomeBinding
    private lateinit var headerBinding: HomeHeaderLayoutBinding
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
        headerBinding = bindView.headerLayout
        val model: CasesInfoViewModel by viewModels()
        model.casesInfo.observe(viewLifecycleOwner,
            Observer<NetResult<List<CaseInfo>>> {
                if (it.result != null) {
                    initAdapter(it.result!!)
                }
            })
    }

    private fun initAdapter(result: List<CaseInfo>) {
        adapter = CasesAdapter(result)
        bindView.rv.adapter = adapter
        adapter.addBtClickListener = object :CasesAdapter.OnClickListener{
            override fun onClick(view: ImageView, caseInfo: CaseInfo) {
                shoppingCarAnimation(view)
            }
        }
    }
    //购物车动画
    private fun shoppingCarAnimation(view: ImageView) {
        val copyImageView = ImageView(view.context)
        copyImageView.apply {
            layoutParams = view.layoutParams
            setImageResource(R.mipmap.icon_add)
        }
        //需要把复制的view 放到上层布局中,否则在动画执行的时候会出现遮挡
        val viewGroup = view.rootView as ViewGroup
        viewGroup.addView(copyImageView, ViewGroup.LayoutParams(view.width, view.height))
        val startLocation = IntArray(2)
        view.getLocationOnScreen(startLocation)
        val stopLocation = IntArray(2)
        bindView.shopcarIv.getLocationOnScreen(stopLocation)
        copyImageView.x = startLocation[0].toFloat()
        copyImageView.y = startLocation[1].toFloat()
        val path = Path()
        path.moveTo(startLocation[0].toFloat(), (startLocation[1]).toFloat())
        path.quadTo(
            (startLocation[0].toFloat() - viewGroup.width / 2),
            startLocation[1].toFloat() - 300,
            (stopLocation[0] + bindView.shopcarIv.width / 2).toFloat(),
            (stopLocation[1]).toFloat()
        )
        ViewAnimator.animate(copyImageView)
            .path(path)
            .scale(0.5f)
            .rotation(-360f)
            .accelerate()
            .duration(1000)
            .onStop {
                viewGroup.removeView(copyImageView)
            }
            .start()
    }

}


