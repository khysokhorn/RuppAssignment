package com.rupp.fe.ruppassignment.http

interface APICallBack {
    fun <D> responseData(d: D)
    fun <E> responseError(e: E)
}