package com.ijk.auth.ui.auth.presenter

import android.view.View
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.ijk.auth.App
import com.ijk.auth.ui.auth.AuthState
import com.ijk.auth.ui.auth.model.AuthModel
import javax.inject.Inject


@InjectViewState
class AuthEmailPresenter : MvpPresenter<AuthModel>() {

    @Inject
    lateinit var mAuth: FirebaseAuth

    init {
        App.getAppComponent().inject(this)
    }

    fun createUserWithEmailAndPassword(v: View, name: String, email: String, password: String){
        try {
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener {  task: Task<AuthResult> ->
                        if (task.isSuccessful){
                            viewState.onResultRequest(AuthState.SUCCESS)

                        } else if (!task.isSuccessful)  {
                            viewState.onResultRequest(AuthState.FAILED)
                        }
                    }
        } catch (e: Exception) {
            viewState.onResultRequest(AuthState.EXCEPTION)
        }
    }

    fun signInWithEmailAndPassword(v: View, email: String, password: String){
        try {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener {  task: Task<AuthResult> ->
                        if (task.isSuccessful){
                            viewState.onResultRequest(AuthState.SUCCESS)

                        } else if (!task.isSuccessful)  {
                            viewState.onResultRequest(AuthState.FAILED)
                        }
                    }
        } catch (e: Exception) {
            viewState.onResultRequest(AuthState.EXCEPTION)
        }
    }

}