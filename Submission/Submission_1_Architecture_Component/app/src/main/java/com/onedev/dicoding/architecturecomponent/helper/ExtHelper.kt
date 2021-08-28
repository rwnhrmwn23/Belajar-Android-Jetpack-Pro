package com.onedev.dicoding.architecturecomponent.helper

import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide

object ExtHelper {
    fun ImageView.loadImageFromDrawable(resDrawable: String) {
        val imageResource = context.resources.getIdentifier(resDrawable, null, context.packageName)
        val res = ContextCompat.getDrawable(context, imageResource)
        Glide.with(context)
            .load(res)
            .into(this)
    }

    fun TextView.setStyleToItalic() {
        this.setTypeface(this.typeface, Typeface.ITALIC)
    }
}