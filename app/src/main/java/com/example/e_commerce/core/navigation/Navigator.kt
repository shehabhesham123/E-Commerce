package com.example.e_commerce.core.navigation

import android.content.Context
import android.content.Intent
import com.example.e_commerce.features.auth.credential.Authenticator
import com.example.e_commerce.features.shopping.app.ui.MainActivity
import javax.inject.Inject

class Navigator @Inject constructor(private val authenticator: Authenticator) {
    fun showMain(context: Context) {
        if (authenticator.isLogin()) {
            // show main activity
            context.startActivity(Intent(context, MainActivity::class.java))
        } else {
            // show login activity
        }
    }
}