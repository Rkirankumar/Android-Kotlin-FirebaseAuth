package com.example.auth.module.firebase

import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.firebase.auth.FirebaseUser
import io.reactivex.Completable

interface FirebaseSource {
    fun login(email: String, password: String): Completable
    
    fun createAccount(email: String, password: String): Completable
    
    fun firebaseAuthWithGoogle(account: GoogleSignInAccount): Completable
    
    fun currentUser(): FirebaseUser?
}