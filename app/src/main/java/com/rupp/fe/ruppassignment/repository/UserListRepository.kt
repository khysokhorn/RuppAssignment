package com.rupp.fe.ruppassignment.repository

import com.rupp.fe.ruppassignment.model.EventModel
import com.rupp.fe.ruppassignment.model.UserModel
import com.rupp.fe.ruppassignment.service.CalendarService
import com.rupp.fe.ruppassignment.service.UserServices
import com.rupp.fe.ruppassignment.service.calendarServices
import com.rupp.fe.ruppassignment.service.services
import io.reactivex.Observable

class UserListRepository {
    fun getUser(): Observable<List<UserModel>> {
        return services.create(UserServices::class.java).getUserList()
    }

    fun getEventList(): Observable<List<EventModel>> {
        return calendarServices.create(CalendarService::class.java).getEventList()
    }
}