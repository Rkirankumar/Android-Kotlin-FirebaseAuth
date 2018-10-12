package com.ijk.auth.mvp

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.ijk.auth.R
import com.ijk.auth.mvp.model.AuthViewModel
import com.ijk.auth.mvp.presenter.AuhtDataPresenter
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : MvpAppCompatActivity(), AuthViewModel {

    @InjectPresenter
    lateinit var mAuhtDataPresenter: AuhtDataPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

    }

    fun onClickLoginButton(v: View){
        mAuhtDataPresenter.signInWithEmailAndPassword(edit_text_email.text.toString(),
                edit_text_password.text.toString())
    }

    override fun startProgressDialog() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun stopProgressDialog() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showResultRequest() {
//        val snack = Snackbar.make(this, "This is a simple Snackbar",Snackbar.LENGTH_LONG)
//        snack.show()
    }

    override fun onSuccessAuth() {
        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
        finish()
    }
}
