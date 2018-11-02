package com.ijk.auth.ui.auth

enum class AuthState(var msg: String) {
    SUCCESS("Authentication success."),
    FAILED("Authentication failed."),
    EXCEPTION("Authentication exception.")
}