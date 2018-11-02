package com.ijk.auth.ui.auth.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.ijk.auth.App
import com.ijk.auth.ui.auth.AuthState
import com.ijk.auth.ui.auth.model.AuthModel
import javax.inject.Inject

@InjectViewState
class AuthGooglePresenter : MvpPresenter<AuthModel>()  {

    @Inject
    lateinit var mAuth: FirebaseAuth

    init {
        App.getAppComponent().inject(this)
    }

    fun firebaseAuthWithGoogle(acct: GoogleSignInAccount) {

        try {
            val credential = GoogleAuthProvider.getCredential(acct.idToken, null)
            mAuth.signInWithCredential(credential)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            viewState.onResultRequest(AuthState.SUCCESS)
                            val user = mAuth.currentUser

                        } else {
                            viewState.onResultRequest(AuthState.FAILED)
                        }
                    }
        } catch (e: Exception) {
            viewState.onResultRequest(AuthState.SUCCESS)
        }
    }

}