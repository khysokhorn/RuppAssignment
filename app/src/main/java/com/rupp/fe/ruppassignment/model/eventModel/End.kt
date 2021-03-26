package com.rupp.fe.ruppassignment.model.eventModel


import com.google.gson.annotations.SerializedName

data class End(
    @SerializedName("dateTime")
    val dateTime: String,
    @SerializedName("timeZone")
    val timeZone: String
)