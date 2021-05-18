package com.rupp.fe.ruppassignment.factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rupp.fe.ruppassignment.repository.CalendarRepository
import com.rupp.fe.ruppassignment.viewModel.EventViewModel

class BaseViewModelFactory() : ViewModelProvider.Factory {
    var context: Context?= null
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EventViewModel::class.java))
            return context?.let { EventViewModel(it) } as T
        throw Exception("Un Know class Name")
    }

}