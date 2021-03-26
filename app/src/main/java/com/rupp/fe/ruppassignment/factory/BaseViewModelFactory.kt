package com.rupp.fe.ruppassignment.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rupp.fe.ruppassignment.repository.GCCEventRepository
import com.rupp.fe.ruppassignment.repository.UserListRepository
import com.rupp.fe.ruppassignment.viewModel.GGCEventViewModel
import com.rupp.fe.ruppassignment.viewModel.LoginViewModel

class BaseViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(UserListRepository()) as T
        } else if (modelClass.isAssignableFrom(GGCEventViewModel::class.java))
            return GGCEventViewModel(GCCEventRepository()) as T
        throw Exception("Un Know class Name")
    }
}