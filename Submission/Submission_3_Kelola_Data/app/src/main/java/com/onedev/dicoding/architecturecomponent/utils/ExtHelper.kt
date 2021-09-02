package com.onedev.dicoding.architecturecomponent.utils

import android.content.Context
import android.graphics.Typeface
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.onedev.dicoding.architecturecomponent.R

object ExtHelper {
    fun Context.showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
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