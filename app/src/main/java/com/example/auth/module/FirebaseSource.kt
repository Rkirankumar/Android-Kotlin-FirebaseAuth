package com.example.auth.module

import io.reactivex.Completable

interface FirebaseSource {
    fun login(email: String, password: String): Completable
}