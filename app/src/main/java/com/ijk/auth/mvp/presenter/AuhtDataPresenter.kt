package com.ijk.auth.mvp.presenter

import android.content.Context
import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.ijk.auth.App
import com.ijk.auth.mvp.model.AuthViewModel
import javax.inject.Inject


@InjectViewState
class AuhtDataPresenter : MvpPresenter<AuthViewModel>() {

    @Inject
    lateinit var mFirebaseAuth: FirebaseAuth
    @Inject
    lateinit var mContext: Context

    init {
        App.getAppComponent().inject(this)
    }


//    private fun execute() {
//        val asyncTask = object : AsyncTask<Void, Void, Void>() {
//            override fun doInBackground(vararg notes: Void): Void? {
//
//
//                return null
//            }
//
//            override fun onPostExecute(result: Void?) {
//
//            }
//        }
//        asyncTask.execute()
//    }

    fun createUserWithEmailAndPassword(email: String, password: String){
        try {
            mFirebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener {  task: Task<AuthResult> ->
                        if (task.isSuccessful){
                            viewState.onSuccessAuth()
                        } else if (!task.isSuccessful)  {
                            Log.e("bla", "onComplete: Failed=" + task.exception)
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
            mFirebaseAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener {  task: Task<AuthResult> ->
                        if (task.isSuccessful){
                            viewState.onSuccessAuth()
                        } else if (!task.isSuccessful)  {
                            Log.e("bla", "onComplete: Failed=" + task.exception)
                        }
                    }
        } catch (e: Exception) {
            e.printStackTrace()
//            Toast.makeText(this, "Authentication exception.",
//                    Toast.LENGTH_SHORT).show()
        }
    }
}