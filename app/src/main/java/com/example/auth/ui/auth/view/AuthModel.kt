package com.example.auth.ui.auth.view

import com.example.auth.ui.auth.AuthState

interface AuthModel {

    fun onResultRequest(state: AuthState)

}