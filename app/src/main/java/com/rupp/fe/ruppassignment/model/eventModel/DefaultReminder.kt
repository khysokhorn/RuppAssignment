package com.rupp.fe.ruppassignment.model.eventModel


import com.google.gson.annotations.SerializedName

data class DefaultReminder(
    @SerializedName("method")
    val method: String,
    @SerializedName("minutes")
    val minutes: Int
)