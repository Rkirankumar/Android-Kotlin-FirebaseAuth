package com.ijk.auth.ui.login.presenter

import android.content.Context
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.ijk.auth.App
import com.ijk.auth.ui.login.AuthState
import com.ijk.auth.ui.login.model.AuthViewModel
import javax.inject.Inject


@InjectViewState
class AuthEmailAndPasswordPresenter : MvpPresenter<AuthViewModel>() {

    @Inject
    lateinit var mAuth: FirebaseAuth
    @Inject
    lateinit var mContext: Context

    init {
        App.getAppComponent().inject(this)
    }

    fun createUserWithEmailAndPassword(email: String, password: String){
        try {
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener {  task: Task<AuthResult> ->
                        if (task.isSuccessful){
                            viewState.onResultRequest(AuthState.SUCCESS_SIGN_UP)
                        } else if (!task.isSuccessful)  {
                            viewState.onResultRequest(AuthState.FAILED_SIGN_UP)
                        }
                    }
        } catch (e: Exception) {
            e.printStackTrace()
//            Toast.makeText(this, "Authentication exception.",
//                    Toast.LENGTH_SHORT).show()
        }
    }

    fun signInWithEmailAndPassword(email: String, password: String){
        try {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener {  task: Task<AuthResult> ->
                        if (task.isSuccessful){
                            viewState.onResultRequest(AuthState.SUCCESS_LOGIN)
                        } else if (!task.isSuccessful)  {
                            viewState.onResultRequest(AuthState.FAILED_LOGIN)
                        }
                    }
        } catch (e: Exception) {
            e.printStackTrace()
//            Toast.makeText(this, "Authentication exception.",
//                    Toast.LENGTH_SHORT).show()
        }
    }
}