package com.example.auth.domain.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.auth.R
import com.example.auth.core.App
import com.example.auth.core.base.BaseViewModel
import com.example.auth.domain.repository.CheckoutRepository
import com.example.auth.domain.repository.UserRepository
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class LoginViewModel @Inject constructor() : BaseViewModel() {
    val loginResult = MutableLiveData<Boolean>()
    val signupResult = MutableLiveData<Boolean>()
    @Inject
    lateinit var userRepository: UserRepository
    
    fun login(email: String, password: String) {
        val disposable = userRepository.login(email, password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                loginResult.value = true
            }, {
                loginResult.value = false
            })
        compositeDisposable.add(disposable)
    }
    
    fun createAccount(email: String, password: String) {
        val disposable = userRepository.createAccount(email, password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                signupResult.value = true
            }, {
                signupResult.value = false
            })
        compositeDisposable.add(disposable)
    }
    
    fun firebaseAuthWithGoogle(account: GoogleSignInAccount) {
        val disposable = userRepository.firebaseAuthWithGoogle(account)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                loginResult.value = true
            }, {
                loginResult.value = false
            })
        compositeDisposable.add(disposable)
    }
}