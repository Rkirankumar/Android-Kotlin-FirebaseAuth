package com.example.auth.domain.repository

import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.firebase.auth.FirebaseUser
import io.reactivex.Completable

interface UserRepository {
    fun login(email: String, password: String): Completable
    
    fun createAccount(email: String, password: String): Completable
    
    fun firebaseAuthWithGoogle(account: GoogleSignInAccount): Completable
    
    fun currentUser(): FirebaseUser?
}