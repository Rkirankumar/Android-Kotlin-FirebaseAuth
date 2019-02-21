package com.example.auth.module.firebase

import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
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
    
    override fun firebaseAuthWithGoogle(account: GoogleSignInAccount): Completable {
        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
        return Completable.create { emitter ->
            firebaseAuth.signInWithCredential(credential)
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
    }
    
    override fun currentUser() = firebaseAuth.currentUser
}