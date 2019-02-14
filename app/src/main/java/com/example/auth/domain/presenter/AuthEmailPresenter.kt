package com.example.auth.domain.presenter

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import javax.inject.Inject

class AuthEmailPresenter {

    @Inject
    lateinit var mAuth: FirebaseAuth

    init {
//        App.getAppComponent().inject(this)
    }

    fun createUserWithEmailAndPassword(name: String, email: String, password: String){
        try {
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener {  task: Task<AuthResult> ->
                        if (task.isSuccessful){
//                            viewState.onResultRequest(AuthState.SUCCESS)
                            updateUserProfile(name)
                        } else if (!task.isSuccessful)  {
//                            viewState.onResultRequest(AuthState.FAILED)
                        }
                    }
        } catch (e: Exception) {
//            viewState.onResultRequest(AuthState.EXCEPTION)
        }
    }

    fun signInWithEmailAndPassword(email: String, password: String){
        try {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener {  task: Task<AuthResult> ->
                        if (task.isSuccessful){
//                            viewState.onResultRequest(AuthState.SUCCESS)
                        } else if (!task.isSuccessful)  {
//                            viewState.onResultRequest(AuthState.FAILED)
                        }
                    }
        } catch (e: Exception) {
//            viewState.onResultRequest(AuthState.EXCEPTION)
        }
    }

    private fun updateUserProfile(name: String) {
        val user = mAuth.currentUser;

        val profileUpdates = UserProfileChangeRequest.Builder()
                .setDisplayName(name)
                .build()

        user?.updateProfile(profileUpdates)
                ?.addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        //do some...
                    }
                }
    }

}