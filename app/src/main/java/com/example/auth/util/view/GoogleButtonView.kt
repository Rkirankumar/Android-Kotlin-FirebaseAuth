package com.example.auth.util.view

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.auth.R
import kotlinx.android.synthetic.main.view_google_button.view.*

class GoogleButtonView @JvmOverloads constructor(
    context: Context, attrSet: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrSet, defStyleAttr) {
    var setOnClickListener: ((view: ConstraintLayout) -> Unit)? = null
    
    init {
        inflate(context, R.layout.view_google_button, this)
        clRoot.setOnClickListener { setOnClickListener?.invoke(it as ConstraintLayout) }
    }

}