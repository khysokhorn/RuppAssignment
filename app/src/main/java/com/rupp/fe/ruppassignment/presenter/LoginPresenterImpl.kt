package com.rupp.fe.ruppassignment.presenter

import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.rupp.fe.ruppassignment.modelData.other.LoginDataInf

// this will link Model with view
class LoginPresenterImpl(private val loginDataInf: LoginDataInf) : LoginPresenter {

    override fun onGmailSign(): GoogleSignInClient {
        return loginDataInf.oSignIn()
    }

    override fun onAuthwithIDToken(idToken: String) {

    }

}