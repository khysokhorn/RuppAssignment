package com.rupp.fe.ruppassignment.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rupp.fe.ruppassignment.http.APICallBack
import com.rupp.fe.ruppassignment.http.APIHandler
import com.rupp.fe.ruppassignment.model.createEvent.CreateEventRespModel
import com.rupp.fe.ruppassignment.model.eventModel.GGCEventModel
import com.rupp.fe.ruppassignment.model.eventModel.ItemModel
import com.rupp.fe.ruppassignment.utils.Resource

class CalendarRepository(val context: Context) : RepositoryIntf {

    override fun postCreateEvent(jsonBody: String): LiveData<Resource<CreateEventRespModel>> {
        TODO("")
    }

    override fun getAllEvent(): MutableLiveData<Resource<GGCEventModel>> {
        val liveData = MutableLiveData<Resource<GGCEventModel>>()
        liveData.postValue(Resource.loading(null))
        APIHandler(context).get<GGCEventModel>(
            "/calendar/v3/calendars/primary/events",
            GGCEventModel::class.java,
            object : APICallBack {
                override fun <D> responseData(d: D) {
                    liveData.postValue(Resource.success(d as GGCEventModel))
                }

                override fun <E> responseError(e: E) {
                    Log.e("TAG", "responseError: something went wrong $e")
                    liveData.postValue(Resource.error(null, e as String))
                    //Log.d("TAG", "responseError: error wit h $errorString")
                }

            })
        return liveData
    }

    override fun getEvent(eventID: String): LiveData<Resource<ItemModel>> {
        TODO("")
    }

    override fun updateEvent(itemModel: ItemModel): LiveData<Resource<ItemModel>> {
        TODO("Not yet implemented")
    }

    override fun deleteEvent(eventID: String): LiveData<Resource<Boolean>> {
        TODO("Not yet implemented")
    }


}


