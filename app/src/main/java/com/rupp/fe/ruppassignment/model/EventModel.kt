package com.rupp.fe.ruppassignment.model

import com.google.gson.annotations.SerializedName

data class EventModel(
        @SerializedName("kind")
        val kind: String
)

data class DefaultReminders(
        val minutes: Int,
        val method: String
)

data class Item(
        val status: String,
        val kind: String,
        val created: String,
        val iCalUID: String,
        val summary: String,
        val description: String
)

//data class End(
//        val dateTime: String
//)
//
//data class RemindersList(
//        val useDefault: Boolean
//)