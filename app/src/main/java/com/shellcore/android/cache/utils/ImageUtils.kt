package com.shellcore.android.cache.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.setImageFromUrl(url: String) {
    Glide.with(this)
        .load(url)
        .centerCrop()
        .into(this)
}