package com.ijk.auth.ui.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.ijk.auth.App
import com.ijk.auth.R
import com.ijk.auth.ui.auth.AuthState.*
import com.ijk.auth.ui.auth.model.AuthModel
import com.ijk.auth.ui.auth.presenter.AuthEmailPresenter
import com.ijk.auth.ui.auth.presenter.AuthGooglePresenter
import com.ijk.auth.ui.base.MainActivity
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject


class LoginActivity : MvpAppCompatActivity(), AuthModel {

    val RC_SIGN_IN = 0

    @InjectPresenter
    lateinit var mEmailPresenter: AuthEmailPresenter

    @InjectPresenter
    lateinit var mGooglePresenter: AuthGooglePresenter

    private lateinit var mGoogleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        App.getAppComponent().inject(this)

        initGoogle()
    }

    private fun initGoogle(){
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
    }

    fun onClickEmailLogin(v: View){
        mEmailPresenter.signInWithEmailAndPassword(v, edit_text_email.text.toString(),
                edit_text_password.text.toString())
    }

    fun onClickSignUpButton(v: View){
        startActivity(Intent(this@LoginActivity, SignUpActivity::class.java))
        finish()
    }

    fun onClickGoogleLogin(v: View){
        val signInIntent = mGoogleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun onResultRequest(state: AuthState) {
        when (state) {
            SUCCESS -> onSuccessAuth()
            FAILED -> showMessage(state)
            EXCEPTION -> showMessage(state)
        }
    }

    private fun onSuccessAuth() {
        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
        finish()
    }

    private fun showMessage(authState: AuthState){
        Toast.makeText(this, authState.msg, Toast.LENGTH_SHORT).show()
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            try {
                val task = GoogleSignIn.getSignedInAccountFromIntent(data)
                val account = task.getResult(ApiException::class.java)
                mGooglePresenter.firebaseAuthWithGoogle(account!!)
            } catch (e: ApiException) {
                onResultRequest(EXCEPTION)
            }
        }
    }
}
