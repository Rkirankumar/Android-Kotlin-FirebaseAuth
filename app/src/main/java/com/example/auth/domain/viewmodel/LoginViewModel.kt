package com.example.auth.domain.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.auth.core.base.BaseViewModel

class LoginViewModel : BaseViewModel(){
    
    val resultDeepLink = MutableLiveData<Boolean>()
    
    fun sendDeepLink(email: String) {
//        val disposable = userRepository.sendDeepLink(email)
//            .observeOn(schedulerProvider.ui())
//            .subscribeOn(schedulerProvider.io())
//            .subscribe({
//                resultDeepLink.value = true
//            }, {
//                resultDeepLink.value = false
//            })
//        compositeDisposable.add(disposable)
    }
}