package com.example.auth.feature.signup

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.auth.R
import com.example.auth.core.base.BaseActivity
import com.example.auth.ui.auth.presenter.AuthEmailPresenter
import com.example.auth.ui.auth.view.AuthModel
import com.example.auth.feature.MainActivity
import com.example.auth.feature.login.LoginActivity
import com.example.auth.ui.auth.AuthState

class SignUpActivity : BaseActivity(), AuthModel {

    lateinit var mAuthEmailPresenter: AuthEmailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

    }

    fun onClickLoginButton(v: View) {
        startActivity(Intent(this@SignUpActivity, LoginActivity::class.java))
        finish()
    }

    fun onClickEmailSignUp(v: View) {
        mAuthEmailPresenter.createUserWithEmailAndPassword(edit_text_name.text.toString(), edit_text_email.text.toString(), edit_text_password.text.toString())
    }

    override fun onResultRequest(state: AuthState) {
        when (state) {
            AuthState.SUCCESS -> onSuccessAuth()
            AuthState.FAILED -> showMessage(state)
            AuthState.EXCEPTION -> showMessage(state)
        }
    }

    private fun onSuccessAuth() {
        startActivity(Intent(this@SignUpActivity, MainActivity::class.java))
        finish()
    }

    private fun showMessage(authState: AuthState){
        Toast.makeText(this, authState.msg, Toast.LENGTH_SHORT).show()
    }

}
