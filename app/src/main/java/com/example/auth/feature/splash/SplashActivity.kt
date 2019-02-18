package com.example.auth.feature.splash

import android.os.Bundle
import com.example.auth.R
import com.example.auth.core.base.BaseActivity
import com.example.auth.domain.viewmodel.LoginViewModel
import com.example.auth.feature.login.LoginActivity
import kotlinx.android.synthetic.main.activity_splash.*
import javax.inject.Inject

class SplashActivity @Inject constructor() : BaseActivity() {
    companion object {
        const val SPLASH_SCREEN_DELAY = 1_000L
    }
    
    @Inject
    lateinit var loginViewModel: LoginViewModel
    
    override fun obtainLayoutResId(): Int = R.layout.activity_splash
    
    private val action: Runnable = Runnable {
        startNextActivity()
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewSkip.setOnClickListener {
            removeHandlerCallbacks(action)
            startNextActivity()
        }
    }
    
    override fun onResume() {
        super.onResume()
        postDelayed(action, SPLASH_SCREEN_DELAY)
    }
    
    override fun onPause() {
        removeHandlerCallbacks(action)
        super.onPause()
    }
    
    private fun startNextActivity() {
        startActivity(LoginActivity.getLaunchIntent(this))
    }
}