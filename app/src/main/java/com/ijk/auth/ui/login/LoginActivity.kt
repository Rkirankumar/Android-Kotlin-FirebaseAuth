package com.ijk.auth.ui.login

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.ijk.auth.R
import com.ijk.auth.ui.login.model.AuthViewModel
import com.ijk.auth.ui.login.presenter.AuthEmailAndPasswordPresenter
import kotlinx.android.synthetic.main.activity_login.*
import com.ijk.auth.ui.login.AuthState.*
import com.ijk.auth.ui.base.MainActivity
import com.ijk.auth.ui.signup.SignUpActivity


class LoginActivity : MvpAppCompatActivity(), AuthViewModel {

    @InjectPresenter
    lateinit var mAuthEmailAndPasswordPresenter: AuthEmailAndPasswordPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun onClickLoginButton(v: View){
        mAuthEmailAndPasswordPresenter.signInWithEmailAndPassword(edit_text_email.text.toString(),
                edit_text_password.text.toString())
    }

    fun onClickSignUpButton(v: View){
            startActivity(Intent(this@LoginActivity, SignUpActivity::class.java))
    }

    override fun onResultRequest(state: AuthState) {
        when (state) {
            SUCCESS_LOGIN -> onSuccessAuth()
            SUCCESS_SIGN_UP -> onSuccessAuth()
            FAILED_LOGIN -> showSnakbar(FAILED_LOGIN.msg)
            FAILED_SIGN_UP -> showSnakbar(FAILED_SIGN_UP.msg)
        }
    }

    fun showSnakbar(msg: String){
        val snack = Snackbar.make(window.decorView.rootView, msg,Snackbar.LENGTH_LONG)
                .show()
    }

    fun onSuccessAuth() {
        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
        finish()
    }
}
