package com.rupp.fe.ruppassignment.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rupp.fe.ruppassignment.model.createEvent.CreateEventRespModel
import com.rupp.fe.ruppassignment.model.eventModel.GGCEventModel
import com.rupp.fe.ruppassignment.model.eventModel.ItemModel
import com.rupp.fe.ruppassignment.utils.Resource

interface RepositoryIntf {
    fun postCreateEvent(jsonBody: String): LiveData<Resource<CreateEventRespModel>>

    // this will get the list of sing item
    fun getAllEvent(): MutableLiveData<Resource<GGCEventModel>>
    fun getEvent(eventID: String): LiveData<Resource<ItemModel>>
    fun updateEvent(itemModel: ItemModel): LiveData<Resource<ItemModel>>
    fun deleteEvent(eventID: String): LiveData<Resource<Boolean>>


}