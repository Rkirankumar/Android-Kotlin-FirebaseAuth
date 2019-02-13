package com.example.auth.ui.auth.presenter

import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.example.auth.core.App
import javax.inject.Inject

class AuthGooglePresenter   {

    @Inject
    lateinit var mAuth: FirebaseAuth

    init {
//        App.getAppComponent().inject(this)
    }

    fun firebaseAuthWithGoogle(acct: GoogleSignInAccount) {

        try {
            val credential = GoogleAuthProvider.getCredential(acct.idToken, null)
            mAuth.signInWithCredential(credential)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
//                            viewState.onResultRequest(AuthState.SUCCESS)

                        } else {
//                            viewState.onResultRequest(AuthState.FAILED)
                        }
                    }
        } catch (e: Exception) {
//            viewState.onResultRequest(AuthState.SUCCESS)
        }
    }

}