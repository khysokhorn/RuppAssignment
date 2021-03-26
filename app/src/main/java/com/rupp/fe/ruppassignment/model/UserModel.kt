package com.rupp.fe.ruppassignment.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class UserModel(
        @SerializedName("name") val name: String,
        @SerializedName("email") val email: String, @SerializedName("address") val address: Address
) : Serializable

data class Address(
        @SerializedName("geo") val geo: Geo
) : Serializable


data class Geo(
        @SerializedName("lat") val lat: String,
        @SerializedName("lng") val lng: String
) : Serializable
