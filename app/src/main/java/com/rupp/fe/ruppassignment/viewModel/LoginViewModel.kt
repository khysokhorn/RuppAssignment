package com.rupp.fe.ruppassignment.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rupp.fe.ruppassignment.model.EventModel
import com.rupp.fe.ruppassignment.model.UserModel
import com.rupp.fe.ruppassignment.repository.UserListRepository
import com.rupp.fe.ruppassignment.utils.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class LoginViewModel(private val repository: UserListRepository) : ViewModel() {
    private val userList = MutableLiveData<Resource<List<UserModel>>>()
    private val eventList = MutableLiveData<Resource<List<EventModel>>>()
    private val compositeDisposable = CompositeDisposable()

    init {
        getUserList()
        eventList();
    }

    private fun getUserList() {
        userList.postValue(Resource.loading(null))
        compositeDisposable.add(
                repository.getUser().subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            userList.postValue(Resource.success(it))
                        }, {
                            userList.postValue(Resource.error(null, "${it.cause} " +
                                    "and ${it.localizedMessage}"))
                        })
        )
    }

    private fun eventList() {
        eventList.postValue(Resource.loading(null))

        repository.getEventList()

        compositeDisposable.add(
                repository.getEventList().subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            Log.d("TAG", "eventList: event lsit $it")
                            eventList.postValue(Resource.success(it))
                        }, {
                            eventList.postValue(Resource.error(null, "${it.message} $it " +
                                    "and ${it.localizedMessage} , ${it.stackTrace} , ${it.suppressed}"))
                        })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    fun getUser(): LiveData<Resource<List<UserModel>>> {
        return userList;
    }

    fun getEventList(): LiveData<Resource<List<EventModel>>> {
        return eventList
    }

}