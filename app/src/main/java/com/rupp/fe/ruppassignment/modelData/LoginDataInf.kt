package com.rupp.fe.ruppassignment.modelData

import com.google.android.gms.auth.api.signin.GoogleSignInClient

interface LoginDataInf {
    interface OnFinishedListener {
        fun onFinished();
    }

    fun oSignIn(onFinishedListener: OnFinishedListener): GoogleSignInClient

    fun onAuth(onFinishedListener: OnFinishedListener)
}