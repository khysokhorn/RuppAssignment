package com.rupp.fe.ruppassignment.model.eventModel


import com.google.gson.annotations.SerializedName

data class Start(
    @SerializedName("dateTime")
    val dateTime: String,
    @SerializedName("timeZone")
    val timeZone: String
)