package com.rupp.fe.ruppassignment.presenter

import com.google.android.gms.auth.api.signin.GoogleSignInClient

interface LoginPresenter {
    fun onGmailSign(): GoogleSignInClient
    fun onAuthwithIDToken(idToken: String)
}