package com.rupp.fe.ruppassignment.service

import com.rupp.fe.ruppassignment.model.EventModel
import com.rupp.fe.ruppassignment.model.UserModel
import com.rupp.fe.ruppassignment.model.eventModel.GGCEventModel
import io.reactivex.Observable
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(Interceptor {
    val request = it.request().newBuilder()
            .addHeader("Authorization", "Bearer " + "ya29.a0AfH6SMCpA_1Qwi2qpTV96b4ZtAJS0Ym-jLQaIuWBsJcM-KLV00RZy_9DWek4H9i8ORP1oe6SNr1eOOpyew-wq_nl6M3OHSfzMVw0dniMpL3YdLvZdNMZR4hf6Q83QSR43YGdgYRXKHVtXgD-5EhizeE-m8so")
            .build()
    return@Interceptor it.proceed(request)
}).build()

val services: Retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()


val calendarServices: Retrofit = Retrofit.Builder()
        .baseUrl("https://www.googleapis.com")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(client)
        .build()

interface UserServices {
    @GET("users/")
    fun getUserList(): Observable<List<UserModel>>
}

interface CalendarService {
    @GET("v3/calendars/primary/events")
    fun getEventList(): Observable<List<EventModel>>

    @GET("/calendar/v3/calendars/primary/events")
    fun getAllEvent(): Observable<GGCEventModel>
}