package com.rupp.fe.ruppassignment.model.createEvent


import com.google.gson.annotations.SerializedName

data class CreateEventModel(
    @SerializedName("description")
    var description: String,
    @SerializedName("end")
    var end: End,
    @SerializedName("location")
    var location: String,
    @SerializedName("recurrence")
    var recurrence: List<String>,
    @SerializedName("reminders")
    var reminders: Reminders,
    @SerializedName("start")
    var start: Start,
    @SerializedName("summary")
    var summary: String
) {
    data class End(
        @SerializedName("dateTime")
        var dateTime: String,
        @SerializedName("timeZone")
        var timeZone: String
    )

    data class Reminders(
        @SerializedName("overrides")
        var overrides: List<Override>,
        @SerializedName("useDefault")
        var useDefault: Boolean
    ) {
        data class Override(
            @SerializedName("method")
            var method: String,
            @SerializedName("minutes")
            var minutes: Int
        )
    }

    data class Start(
        @SerializedName("dateTime")
        var dateTime: String,
        @SerializedName("timeZone")
        var timeZone: String
    )
}