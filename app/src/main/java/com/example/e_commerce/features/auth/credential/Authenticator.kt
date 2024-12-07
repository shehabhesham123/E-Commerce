package com.example.e_commerce.features.auth.credential

import javax.inject.Inject

class Authenticator @Inject constructor() {
    fun isLogin(): Boolean {
        // as default
        return true
    }
}