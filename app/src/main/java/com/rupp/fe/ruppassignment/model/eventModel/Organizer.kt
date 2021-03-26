package com.rupp.fe.ruppassignment.model.eventModel


import com.google.gson.annotations.SerializedName

data class Organizer(
    @SerializedName("email")
    val email: String,
    @SerializedName("self")
    val self: Boolean
)