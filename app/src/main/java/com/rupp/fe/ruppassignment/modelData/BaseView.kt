package com.rupp.fe.ruppassignment.modelData

interface BaseView {
    fun isOnProgress(boolean: Boolean)
    fun onError(message: String?)
}