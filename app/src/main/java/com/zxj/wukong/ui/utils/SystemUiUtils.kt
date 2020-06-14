package com.zxj.wukong.ui.utils

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue

object SystemUiUtils {

    fun getStatusBarHeight(context: Context): Int {
        val resources: Resources = context.getResources()
        val resourceId: Int = resources.getIdentifier("status_bar_height", "dimen", "android")
        return resources.getDimensionPixelSize(resourceId)
    }

    fun getActionBarHeight(context: Context):Int{
        val tv = TypedValue();
        var actionBarHeight = 0;
        if (context.getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
            actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data, context.getResources().getDisplayMetrics());
        }
        return actionBarHeight
    }
}