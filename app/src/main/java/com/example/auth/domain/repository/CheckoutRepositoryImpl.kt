package com.example.auth.domain.repository

import com.example.auth.module.FirebaseSource
import javax.inject.Inject

class CheckoutRepositoryImpl @Inject constructor() : CheckoutRepository {
    
    @Inject
    lateinit var firebaseSource: FirebaseSource
    
    override fun login(email: String, password: String)
        = firebaseSource.login(email, password)
}