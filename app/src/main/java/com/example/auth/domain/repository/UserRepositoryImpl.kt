package com.example.auth.domain.repository

import com.example.auth.module.firebase.FirebaseSource
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor() : UserRepository {
    @Inject
    lateinit var firebaseSource: FirebaseSource
    
    override fun login(email: String, password: String)
        = firebaseSource.login(email, password)
    
    override fun createAccount(email: String, password: String)
        = firebaseSource.createAccount(email, password)
    
    override fun currentUser() =  firebaseSource.currentUser()
}