package com.ijk.auth.ui.auth.view

import com.arellomobile.mvp.MvpView
import com.ijk.auth.ui.auth.AuthState

interface AuthModel: MvpView {

    fun onResultRequest(state: AuthState)

}