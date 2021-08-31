package com.onedev.dicoding.architecturecomponent.utils

import android.graphics.Typeface
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.onedev.dicoding.architecturecomponent.R

object ExtHelper {
    fun ImageView.loadImageFromDrawable(resDrawable: String) {
        val imageResource = context.resources.getIdentifier(resDrawable, null, context.packageName)
        val res = ContextCompat.getDrawable(context, imageResource)
        Glide.with(context)
            .load(res)
            .into(this)
    }

    fun ImageView.loadImage(url: String) {
        Glide.with(context)
            .load(url)
            .placeholder(R.drawable.ic_loading)
            .error(R.drawable.ic_error)
            .into(this)
    }

    fun TextView.setStyleToItalic() {
        this.setTypeface(this.typeface, Typeface.ITALIC)
    }
}