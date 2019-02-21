package com.example.auth.domain.repository

import com.example.auth.module.firebase.FirebaseSource
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor() : UserRepository {
    @Inject
    lateinit var firebaseSource: FirebaseSource
    
    override fun login(email: String, password: String)
        = firebaseSource.login(email, password)
    
    override fun createAccount(email: String, password: String)
        = firebaseSource.createAccount(email, password)
    
    override fun firebaseAuthWithGoogle(account: GoogleSignInAccount)
        = firebaseSource.firebaseAuthWithGoogle(account)
    
    override fun currentUser() = firebaseSource.currentUser()
}