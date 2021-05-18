package com.rupp.fe.ruppassignment.viewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rupp.fe.ruppassignment.model.createEvent.CreateEventRespModel
import com.rupp.fe.ruppassignment.model.eventModel.GGCEventModel
import com.rupp.fe.ruppassignment.model.eventModel.ItemModel
import com.rupp.fe.ruppassignment.repository.CalendarRepository
import com.rupp.fe.ruppassignment.repository.RepositoryIntf
import com.rupp.fe.ruppassignment.utils.Resource


class EventViewModel(context: Context) : ViewModel(),
    RepositoryIntf {
    private val calendarRepository = CalendarRepository(context)

    //  get all user event
    private fun getEvent() {

    }


    override fun postCreateEvent(jsonBody: String): LiveData<Resource<CreateEventRespModel>> {
        return calendarRepository.postCreateEvent(jsonBody)
    }

    override fun getAllEvent(): MutableLiveData<Resource<GGCEventModel>> {
        return calendarRepository.getAllEvent()
    }

    override fun getEvent(eventID: String): LiveData<Resource<ItemModel>> {
        return calendarRepository.getEvent(eventID)
    }

    override fun updateEvent(itemModel: ItemModel): LiveData<Resource<ItemModel>> {
        TODO("Not yet implemented")
    }

    override fun deleteEvent(eventID: String): LiveData<Resource<Boolean>> {
        TODO("Not yet implemented")
    }


    override fun onCleared() {
        super.onCleared()

    }
}