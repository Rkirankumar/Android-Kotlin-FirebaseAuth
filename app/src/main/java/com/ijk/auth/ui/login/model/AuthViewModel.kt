package com.ijk.auth.ui.login.model

import com.arellomobile.mvp.MvpView
import com.ijk.auth.ui.login.AuthState

interface AuthViewModel: MvpView {

    fun onResultRequest(state: AuthState)

}