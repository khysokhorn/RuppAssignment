package com.rupp.fe.ruppassignment.model.eventModel

import com.google.gson.annotations.SerializedName

data class GGCEventModel(
    @SerializedName("accessRole")
        val accessRole: String,
    @SerializedName("defaultReminders")
        val defaultReminders: List<DefaultReminder>,
    @SerializedName("etag")
        val etag: String,
    @SerializedName("items")
        var itemModels: List<ItemModel>,
    @SerializedName("kind")
        val kind: String,
    @SerializedName("nextSyncToken")
        val nextSyncToken: String,
    @SerializedName("summary")
        val summary: String,
    @SerializedName("timeZone")
        val timeZone: String,
    @SerializedName("updated")
        val updated: String
)