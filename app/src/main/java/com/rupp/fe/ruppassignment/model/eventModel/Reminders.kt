package com.rupp.fe.ruppassignment.model.eventModel


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Reminders(
    @SerializedName("overrides")
    val overrides: List<Override>,
    @SerializedName("useDefault")
    val useDefault: Boolean
)  : Serializable