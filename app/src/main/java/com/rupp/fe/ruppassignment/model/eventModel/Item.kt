package com.rupp.fe.ruppassignment.model.eventModel


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("colorId")
    val colorId: String,
    @SerializedName("created")
    val created: String,
    @SerializedName("creator")
    val creator: Creator,
    @SerializedName("description")
    val description: String,
    @SerializedName("end")
    val end: End,
    @SerializedName("etag")
    val etag: String,
    @SerializedName("eventType")
    val eventType: String,
    @SerializedName("guestsCanModify")
    val guestsCanModify: Boolean,
    @SerializedName("htmlLink")
    val htmlLink: String,
    @SerializedName("iCalUID")
    val iCalUID: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("kind")
    val kind: String,
    @SerializedName("organizer")
    val organizer: Organizer,
    @SerializedName("recurrence")
    val recurrence: List<String>,
    @SerializedName("reminders")
    val reminders: Reminders,
    @SerializedName("sequence")
    val sequence: Int,
    @SerializedName("start")
    val start: Start,
    @SerializedName("status")
    val status: String,
    @SerializedName("summary")
    val summary: String,
    @SerializedName("updated")
    val updated: String
)