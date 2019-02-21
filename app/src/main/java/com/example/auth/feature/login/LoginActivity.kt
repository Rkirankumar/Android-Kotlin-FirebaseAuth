package com.example.auth.feature.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.lifecycle.Observer
import com.example.auth.BuildConfig
import com.example.auth.R
import com.example.auth.core.base.BaseActivity
import com.example.auth.domain.viewmodel.LoginViewModel
import com.example.auth.feature.MainActivity
import com.example.auth.feature.signup.SignUpActivity
import com.example.auth.util.isEmailValid
import com.example.auth.util.isPasswordValid
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity @Inject constructor() : BaseActivity() {
    companion object {
        const val CODE_SIGN_IN = 200
        
        fun getLaunchIntent(context: Context): Intent {
            val intent = Intent(context, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            return intent
        }
    }
    
    @Inject
    lateinit var loginViewModel: LoginViewModel
    
    override fun obtainLayoutResId() = R.layout.activity_login
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setupListener()
        setupViewModel()
    }
    
    private fun setupListener() {
        bGoogle.setOnClickListener = {
            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(BuildConfig.GOOGLE_CLIENT_ID)
                .requestEmail()
                .build()
            val mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
            val signInIntent = mGoogleSignInClient.signInIntent
            startActivityForResult(signInIntent, CODE_SIGN_IN)
        }
        tvSignUpNow.setOnClickListener {
            startActivity(SignUpActivity.getLaunchIntent(this))
        }
        tvLogin.setOnClickListener {
            attemptLogin()
        }
    }
    
    private fun setupViewModel() {
        loginViewModel.loginResult.observe(this, Observer {
            if (it) {
                startActivity(MainActivity.getLaunchIntent(this))
            } else {
                //todo make it to the end
            }
            hideProgress()
        })
    }
    
    private fun attemptLogin() {
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
            loginViewModel.login(emailStr, passwordStr)
        }
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CODE_SIGN_IN) {
            try {
                val task = GoogleSignIn.getSignedInAccountFromIntent(data)
                val account = task.getResult(ApiException::class.java)
                if (account != null) {
                    loginViewModel.firebaseAuthWithGoogle(account)
                }
            } catch (e: ApiException) {
            
            }
        }
    }
}
