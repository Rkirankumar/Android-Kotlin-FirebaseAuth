package com.example.auth.feature.signup

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.auth.R
import com.example.auth.core.base.BaseActivity
import com.example.auth.domain.presenter.AuthEmailPresenter
import com.example.auth.feature.login.LoginActivity
import kotlinx.android.synthetic.main.activity_signup.*

class SignUpActivity : BaseActivity() {
    companion object {
        fun getLaunchIntent(context: Context): Intent {
            val intent = Intent(context, SignUpActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            return intent
        }
    }
    
    override fun obtainLayoutResId() = R.layout.activity_signup
    
    lateinit var mAuthEmailPresenter: AuthEmailPresenter
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupListener()
    }
    
    private fun setupListener() {
        tvLoginMe.setOnClickListener {
            startActivity(LoginActivity.getLaunchIntent(this))
        }
    }
    
    fun onClickEmailSignUp(v: View) {
//        mAuthEmailPresenter.createUserWithEmailAndPassword(edit_text_name.text.toString(), edit_text_email.text.toString(), edit_text_password.text.toString())
    }
//    override fun onResultRequest(state: AuthState) {
//        when (state) {
//            AuthState.SUCCESS -> onSuccessAuth()
//            AuthState.FAILED -> showMessage(state)
//            AuthState.EXCEPTION -> showMessage(state)
//        }
//    }
//    private fun showMessage(authState: AuthState){
//        Toast.makeText(this, authState.msg, Toast.LENGTH_SHORT).show()
//    }
}
