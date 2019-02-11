package com.ijk.auth.feature.login

import android.os.Bundle
import android.view.View
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.ijk.auth.core.App
import com.ijk.auth.core.BaseActivity
import com.ijk.auth.ui.auth.AuthState
import com.ijk.auth.ui.auth.AuthState.*
import com.ijk.auth.ui.auth.presenter.AuthEmailPresenter
import com.ijk.auth.ui.auth.presenter.AuthGooglePresenter
import com.ijk.auth.ui.auth.view.AuthModel

class LoginActivity : BaseActivity(), AuthModel {

    private val CODE_SIGN_IN = 0
    
    lateinit var mEmailPresenter: AuthEmailPresenter

    lateinit var mGooglePresenter: AuthGooglePresenter

    private lateinit var mGoogleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_login)

        App.getAppComponent().inject(this)

        initGoogle()
    }

    private fun initGoogle(){
//        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestIdToken(getString(R.string.default_web_client_id))
//                .requestEmail()
//                .build()

//        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
    }

    fun onClickEmailLogin(v: View) {
//        mEmailPresenter.signInWithEmailAndPassword(edit_text_email.text.toString(), edit_text_password.text.toString())
    }

    fun onClickSignUpButton(v: View) {
//        startActivity(Intent(this@LoginActivity, SignUpActivity::class.java))
//        finish()
    }

    fun onClickGoogleLogin(v: View) {
        val signInIntent = mGoogleSignInClient.signInIntent
//        startActivityForResult(signInIntent, CODE_SIGN_IN)
    }

    override fun onResultRequest(state: AuthState) {
        when (state) {
            SUCCESS -> onSuccessAuth()
            FAILED -> showMessage(state)
            EXCEPTION -> showMessage(state)
        }
    }

    private fun onSuccessAuth() {
//        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
//        finish()
    }

    private fun showMessage(authState: AuthState){
//        Toast.makeText(this, authState.msg, Toast.LENGTH_SHORT).show()
    }

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
