package com.example.auth.core.base

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.example.auth.util.gone
import com.example.auth.util.visible
import kotlinx.android.synthetic.main.view_progress.*

abstract class BaseActivity: AppCompatActivity() {
    private val handler: Handler by lazy {
        Handler(Looper.getMainLooper())
    }
    
    @LayoutRes
    internal abstract fun obtainLayoutResId(): Int
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(obtainLayoutResId())
    }
    
    fun showProgress() {
        progress?.visible()
    }
    
    fun hideProgress() {
        progress?.gone()
    }
    
    fun hideKeyboard() {
        val view = this.currentFocus
        view ?: return
        val service = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        service.hideSoftInputFromWindow(view.windowToken, 0)
    }
    
    fun postDelayed(action: Runnable, delay: Long) {
        handler.postDelayed(action, delay)
    }
    
    fun removeHandlerCallbacks(action: Runnable) {
        handler.removeCallbacks(action)
    }
}