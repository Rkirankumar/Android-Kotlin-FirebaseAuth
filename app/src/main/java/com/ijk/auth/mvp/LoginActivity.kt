package com.ijk.auth.mvp

import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.transition.Fade
import android.support.v4.view.ViewCompat
import android.view.View
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.ijk.auth.R
import com.ijk.auth.mvp.model.AuthViewModel
import com.ijk.auth.mvp.presenter.AuhtDataPresenter
import kotlinx.android.synthetic.main.activity_login.*
import android.util.Pair as UtilPair


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

    fun onClickSignUpButton(v: View){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){

            val options = ActivityOptions.makeSceneTransitionAnimation(this,
                    UtilPair.create(text_view_logo, ViewCompat.getTransitionName(text_view_logo)),
                    UtilPair.create(edit_text_password, ViewCompat.getTransitionName(edit_text_password)),
                    UtilPair.create(edit_text_email, ViewCompat.getTransitionName(edit_text_email)),
                    UtilPair.create(button_sign_up, ViewCompat.getTransitionName(button_sign_up)))

            startActivity(Intent(this@LoginActivity,
                    SignUpActivity::class.java), options.toBundle())
        }else startActivity(Intent(this@LoginActivity, SignUpActivity::class.java))

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
