package com.patronusstudio.productflavorexample

import android.content.Context
import android.content.Intent
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions


class LoginHelper(private val context: Context) : BaseLogin() {

    private lateinit var mGoogleSignInClient: GoogleSignInClient

    override fun init() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()
        mGoogleSignInClient = GoogleSignIn.getClient(context, gso)
    }

    override fun getLoginIntent(): Intent {
        return mGoogleSignInClient.signInIntent
    }

}