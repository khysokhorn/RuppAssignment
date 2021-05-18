package com.rupp.fe.ruppassignment.model.createEvent


import com.google.gson.annotations.SerializedName

data class CreateEventRespModel(
    @SerializedName("created")
    var created: String,
    @SerializedName("creator")
    var creator: Creator,
    @SerializedName("description")
    var description: String,
    @SerializedName("end")
    var end: End,
    @SerializedName("etag")
    var etag: String,
    @SerializedName("eventType")
    var eventType: String,
    @SerializedName("htmlLink")
    var htmlLink: String,
    @SerializedName("iCalUID")
    var iCalUID: String,
    @SerializedName("id")
    var id: String,
    @SerializedName("kind")
    var kind: String,
    @SerializedName("location")
    var location: String,
    @SerializedName("organizer")
    var organizer: Organizer,
    @SerializedName("recurrence")
    var recurrence: List<String>,
    @SerializedName("reminders")
    var reminders: Reminders,
    @SerializedName("sequence")
    var sequence: Int,
    @SerializedName("start")
    var start: Start,
    @SerializedName("status")
    var status: String,
    @SerializedName("summary")
    var summary: String,
    @SerializedName("updated")
    var updated: String
) {
    data class Creator(
        @SerializedName("email")
        var email: String,
        @SerializedName("self")
        var self: Boolean
    )

    data class End(
        @SerializedName("dateTime")
        var dateTime: String,
        @SerializedName("timeZone")
        var timeZone: String
    )

    data class Organizer(
        @SerializedName("email")
        var email: String,
        @SerializedName("self")
        var self: Boolean
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