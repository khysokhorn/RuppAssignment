package com.rupp.fe.ruppassignment.modelData.other

import com.google.android.gms.auth.api.signin.GoogleSignInClient

interface LoginDataInf {
    fun oSignIn(): GoogleSignInClient

    fun onAuth()
}