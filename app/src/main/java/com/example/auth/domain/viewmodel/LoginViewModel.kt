package com.example.auth.domain.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.auth.R
import com.example.auth.core.App
import com.example.auth.core.base.BaseViewModel
import com.example.auth.domain.repository.CheckoutRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class LoginViewModel @Inject constructor() : BaseViewModel() {
    val loginResult = MutableLiveData<Boolean>()
    
    @Inject
    lateinit var checkoutRepository: CheckoutRepository
    
    fun login(email: String, password: String) {
        val disposable = checkoutRepository.login(email, password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                loginResult.value = true
            }, {
                loginResult.value = false
            })
        compositeDisposable.add(disposable)
    }
 
//    private fun saveUserInfo(): Completable {
//        return Completable.create { emitter ->
//            network.getAuthenticationAPIClient()
//                .userInfo(network.getTokenService().getAccessToken())
//                .start(object : BaseCallback<UserProfile, AuthenticationException> {
//                    override fun onSuccess(payload: UserProfile) {
//
//                        dealerId = getDealerId(payload)
//                        userPermissions = getUserPermissions(payload)
//                        roles = getRoles(payload)
//
//                        preferences.saveUserPermissions(userPermissions!!)
//                        preferences.saveRoles(roles!!)
//                        preferences.saveDealerId(dealerId)
//
//                        println("GETZ.CheckDetailsPresenter.onSuccess ---> dealerId=$dealerId userPermissions=$userPermissions roles=$roles")
//
//                        saveUserDisplayName(payload)
//                        emitter.onComplete()
//                    }
//
//                    override fun onFailure(error: AuthenticationException) {
//                        emitter.onError(error)
//                    }
//                })
//        }
//    }
}