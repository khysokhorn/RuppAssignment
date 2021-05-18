package com.rupp.fe.ruppassignment.model


import com.google.gson.annotations.SerializedName

data class ErrorResponseModell(
    @SerializedName("error")
    var error: Error
) {
    data class Error(
        @SerializedName("code")
        var code: Int,
        @SerializedName("errors")
        var errors: List<Error>,
        @SerializedName("message")
        var message: String,
        @SerializedName("status")
        var status: String
    ) {
        data class Error(
            @SerializedName("domain")
            var domain: String,
            @SerializedName("location")
            var location: String,
            @SerializedName("locationType")
            var locationType: String,
            @SerializedName("message")
            var message: String,
            @SerializedName("reason")
            var reason: String
        )
    }
}