package com.example.auth.module.firebase

import com.google.firebase.auth.FirebaseAuth
import io.reactivex.Completable
import javax.inject.Inject

class FirebaseSourceImpl @Inject constructor() : FirebaseSource {
    private val firebaseAuth: FirebaseAuth by lazy {
        FirebaseAuth.getInstance()
    }
    
    override fun login(email: String, password: String) = Completable.create { emitter ->
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    if (!emitter.isDisposed) {
                        emitter.onComplete()
                    }
                }
            }
            .addOnFailureListener {
                if (!emitter.isDisposed) {
                    emitter.onError(Throwable())
                }
            }
    }
    
    override fun createAccount(email: String, password: String) = Completable.create { emitter ->
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    if (!emitter.isDisposed) {
                        emitter.onComplete()
                    }
                }
            }
            .addOnFailureListener {
                if (!emitter.isDisposed) {
                    emitter.onError(Throwable())
                }
            }
    }
    
    override fun currentUser() =  firebaseAuth.currentUser
}