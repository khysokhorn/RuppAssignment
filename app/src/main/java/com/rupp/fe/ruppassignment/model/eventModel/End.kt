package com.rupp.fe.ruppassignment.model.eventModel


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class End(
    @SerializedName("dateTime")
    val dateTime: String,
    @SerializedName("timeZone")
    val timeZone: String
): Serializable