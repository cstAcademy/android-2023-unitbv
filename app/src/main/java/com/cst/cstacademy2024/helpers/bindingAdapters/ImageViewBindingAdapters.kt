package com.cst.cstacademy2024.helpers.bindingAdapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.cst.cstacademy2024.R

@BindingAdapter("url")
fun loadImageFromUrl(
    imageView: ImageView,
    url: String?
) = url?.let {
    Glide
        .with(imageView.context)
        .load(url)
        .placeholder(R.drawable.account_circle)
        .into(imageView);
}