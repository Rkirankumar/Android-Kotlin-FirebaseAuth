package com.example.auth.util

import android.view.View
import android.widget.EditText

fun EditText.filledText(): String = text.toString().trim()

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}