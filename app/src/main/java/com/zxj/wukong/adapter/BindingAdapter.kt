package com.zxj.wukong.adapter

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter(value = ["imageFromUrl", "placeHolder", "errorHolder"], requireAll = false)
fun imageFromUrl(imageView: ImageView, url: String, holder: Drawable?, error: Drawable?) {
    Glide.with(imageView).load(url).apply {
        if (holder != null) placeholder(holder)
        if (error != null) error(error)
    }.into(imageView)
}