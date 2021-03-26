package com.rupp.fe.ruppassignment.presenter

import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.rupp.fe.ruppassignment.modelData.LoginDataInf
import com.rupp.fe.ruppassignment.view.activity.viewInf.LoginView

// this will link Model with view
class LoginPresenterImpl(private val loginView: LoginView,
                         private val loginDataInf: LoginDataInf) :
        LoginPresenter, LoginDataInf.OnFinishedListener {

    override fun onGmailSign(): GoogleSignInClient {
        return loginDataInf.oSignIn(this)
    }

    override fun onAuthwithIDToken(idToken: String) {

    }

    override fun onFinished() {

    }
}