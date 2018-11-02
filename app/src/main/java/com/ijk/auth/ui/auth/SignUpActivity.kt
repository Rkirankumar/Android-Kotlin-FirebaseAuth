package com.ijk.auth.ui.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.ijk.auth.R
import com.ijk.auth.ui.auth.model.AuthModel
import com.ijk.auth.ui.auth.presenter.AuthEmailPresenter
import kotlinx.android.synthetic.main.activity_signup.*

class SignUpActivity : MvpAppCompatActivity(), AuthModel {

    @InjectPresenter
    lateinit var mAuthEmailPresenter: AuthEmailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

    }

    fun onClickLoginButton(v: View){
        startActivity(Intent(this@SignUpActivity, LoginActivity::class.java))
        finish()
    }

    fun onClickEmailSignUp(v: View){
        mAuthEmailPresenter.createUserWithEmailAndPassword(v, edit_text_name.text.toString(), edit_text_email.text.toString(),
                edit_text_password.text.toString())
    }

    override fun onResultRequest(state: AuthState) {

    }

}
