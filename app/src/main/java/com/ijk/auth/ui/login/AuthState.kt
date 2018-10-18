package com.ijk.auth.ui.login

enum class AuthState(var msg: String) {
    SUCCESS_SIGN_UP("Success sign up."),
    SUCCESS_LOGIN("Success login."),
    FAILED_LOGIN("Login failed."),
    FAILED_SIGN_UP("Sign up failed.")
}