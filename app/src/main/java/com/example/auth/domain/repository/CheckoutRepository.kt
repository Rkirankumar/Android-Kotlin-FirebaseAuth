package com.example.auth.domain.repository

import io.reactivex.Completable

interface CheckoutRepository {
    fun login(email: String, password: String): Completable
}