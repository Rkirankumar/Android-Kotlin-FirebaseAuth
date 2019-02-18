package com.example.auth.feature.signup

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.lifecycle.Observer
import com.example.auth.R
import com.example.auth.core.base.BaseActivity
import com.example.auth.domain.viewmodel.LoginViewModel
import com.example.auth.feature.MainActivity
import com.example.auth.feature.login.LoginActivity
import com.example.auth.util.isEmailValid
import com.example.auth.util.isPasswordValid
import kotlinx.android.synthetic.main.activity_signup.*
import javax.inject.Inject

class SignUpActivity : BaseActivity() {
    companion object {
        fun getLaunchIntent(context: Context): Intent {
            val intent = Intent(context, SignUpActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            return intent
        }
    }
    
    @Inject
    lateinit var loginViewModel: LoginViewModel
    
    override fun obtainLayoutResId() = R.layout.activity_signup
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupListener()
        setupViewModel()
    }
    
    private fun setupListener() {
        tvLoginMe.setOnClickListener {
            startActivity(LoginActivity.getLaunchIntent(this))
        }
        tvCreateAccount.setOnClickListener {
            attemptCreateAccount()
        }
    }
    
    private fun setupViewModel() {
        loginViewModel.signupResult.observe(this, Observer {
            if (it) {
                startActivity(MainActivity.getLaunchIntent(this))
            } else {
                //todo make it to the end
            }
            hideProgress()
        })
    }
    
    private fun attemptCreateAccount() {
        edEmail.error = null
        edPassword.error = null
        val emailStr = edEmail.text.toString()
        val passwordStr = edPassword.text.toString()
        var cancel = false
        var focusView: View? = null
        if (!TextUtils.isEmpty(passwordStr) && !passwordStr.isPasswordValid()) {
            edPassword.error = getString(R.string.error_invalid_password)
            focusView = edPassword
            cancel = true
        }
        if (TextUtils.isEmpty(emailStr)) {
            edEmail.error = getString(R.string.error_field_required)
            focusView = edEmail
            cancel = true
        } else if (!emailStr.isEmailValid()) {
            edEmail.error = getString(R.string.error_invalid_email)
            focusView = edEmail
            cancel = true
        }
        if (cancel) {
            focusView?.requestFocus()
        } else {
            showProgress()
            loginViewModel.createAccount(emailStr, passwordStr)
        }
    }
}
