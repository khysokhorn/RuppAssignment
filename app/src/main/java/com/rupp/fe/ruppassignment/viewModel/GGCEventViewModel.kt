package com.rupp.fe.ruppassignment.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rupp.fe.ruppassignment.model.eventModel.GGCEventModel

import com.rupp.fe.ruppassignment.repository.GCCEventRepository
import com.rupp.fe.ruppassignment.utils.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class GGCEventViewModel(private val gccEventRepository: GCCEventRepository) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val ggcEventModelLiveData = MutableLiveData<Resource<GGCEventModel>>()

    init {
        getEvent()
    }

    //  get all user event
    private fun getEvent() {
        ggcEventModelLiveData.postValue(Resource.loading(null))
        compositeDisposable.add(
                gccEventRepository.getAllEventList()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                {
                                    ggcEventModelLiveData.postValue(Resource.success(it))
                                }, {
                            ggcEventModelLiveData.postValue(Resource.error(null, "${it.cause} " +
                                    "and ${it.localizedMessage}"))
                        }
                        )
        )
    }

    public fun getAllVentList(): LiveData<Resource<GGCEventModel>> {
        return ggcEventModelLiveData
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}