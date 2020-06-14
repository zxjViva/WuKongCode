package com.zxj.wukong.ui.utils

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.zxj.wukong.R
import com.zxj.wukong.databinding.HomeHeaderLayoutBinding

class HomeHeaderBehavior : CoordinatorLayout.Behavior<View> {
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor() : super()

    override fun onDependentViewChanged(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {
        var appbar = parent.findViewById<View>(R.id.appbar)
        HomeHeaderLayoutBinding.bind(child)
        return super.onDependentViewChanged(parent, child, dependency)
    }

    override fun layoutDependsOn(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {
        return dependency.id == R.id.rv
    }
}