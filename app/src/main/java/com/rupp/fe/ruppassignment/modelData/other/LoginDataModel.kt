package com.rupp.fe.ruppassignment.modelData.other

import android.content.Context
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

class LoginDataModel(private val context: Context) : LoginDataInf {

    override fun oSignIn(): GoogleSignInClient {
        return signGoogle();
    }

    override fun onAuth() {

    }

    // login with google here
    private fun signGoogle(): GoogleSignInClient {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .requestIdToken("890025239036-030pb3rh83crbr8h243oajb4dacr5tth.apps.googleusercontent.com")
                .build()
        return GoogleSignIn.getClient(context, gso)
    }

}