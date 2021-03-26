package com.rupp.fe.ruppassignment.repository

import com.rupp.fe.ruppassignment.model.EventModel
import com.rupp.fe.ruppassignment.model.eventModel.GGCEventModel
import com.rupp.fe.ruppassignment.service.CalendarService
import com.rupp.fe.ruppassignment.service.calendarServices
import io.reactivex.Observable

class GCCEventRepository {
    fun getAllEventList(): Observable<GGCEventModel> {
        return calendarServices.create(CalendarService::class.java).getAllEvent()
    }
}