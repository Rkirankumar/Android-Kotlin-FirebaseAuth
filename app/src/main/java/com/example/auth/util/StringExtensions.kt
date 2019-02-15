package com.example.auth.util

fun String.isEmailValid(): Boolean {
    return this.contains("@")
}

fun String.isPasswordValid(): Boolean {
    return this.length > 4
}