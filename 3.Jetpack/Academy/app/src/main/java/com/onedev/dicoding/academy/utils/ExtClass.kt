package com.onedev.dicoding.academy.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.onedev.dicoding.academy.R

object ExtClass {
    fun ImageView.loadImage(url: String) {
        Glide.with(this.context)
            .load(url)
            .placeholder(R.drawable.ic_loading)
            .error(R.drawable.ic_error)
            .into(this)
    }

    fun ImageView.loadImageWithTransform(url: String) {
        Glide.with(this.context)
            .load(url)
            .transform(RoundedCorners(20))
            .placeholder(R.drawable.ic_loading)
            .error(R.drawable.ic_error)
            .into(this)
    }
}