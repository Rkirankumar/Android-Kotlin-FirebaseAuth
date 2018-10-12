package com.ijk.auth.mvp.model

import com.arellomobile.mvp.MvpView

interface AuthViewModel: MvpView {

    fun startProgressDialog()

    fun stopProgressDialog()

    fun showResultRequest()

    fun onSuccessAuth()

}