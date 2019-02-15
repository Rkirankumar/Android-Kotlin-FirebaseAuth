package com.example.auth.feature.login

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
import com.example.auth.feature.signup.SignUpActivity
import com.example.auth.util.isEmailValid
import com.example.auth.util.isPasswordValid
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity @Inject constructor() : BaseActivity() {
    companion object {
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
        bGoogle.setOnClickListener {
        
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
            if (it){
                startActivity(MainActivity.getLaunchIntent(this))
            } else {
                startActivity(SignUpActivity.getLaunchIntent(this))
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
    
    private fun initGoogle() {
//        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestIdToken(getString(R.string.default_web_client_id))
//                .requestEmail()
//                .build()
//        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
    }
    
//    fun onClickGoogleLogin(v: View) {
//        private lateinit var mGoogleSignInClient: GoogleSignInClient
//        val signInIntent = mGoogleSignInClient.signInIntent
//        startActivityForResult(signInIntent, CODE_SIGN_IN)
//    }
    
//    private fun onSuccessAuth() {
//        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
//        finish()
//    }
//    private fun showMessage(authState: AuthState){
//        Toast.makeText(this, authState.msg, Toast.LENGTH_SHORT).show()
//    }
//    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == CODE_SIGN_IN) {
//            try {
//                val task = GoogleSignIn.getSignedInAccountFromIntent(data)
//                val account = task.getResult(ApiException::class.java)
//                mGooglePresenter.firebaseAuthWithGoogle(account!!)
//            } catch (e: ApiException) {
//                onResultRequest(EXCEPTION)
//            }
//        }
//    }
}
