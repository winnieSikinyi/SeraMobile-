package com.greenrevive.serawaziapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greenrevive.serawaziapplication.model.RegisterRequest
import com.greenrevive.serawaziapplication.model.RegisterResponse
import com.greenrevive.serawaziapplication.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel:ViewModel() {
    var userrepo = UserRepository()
    val regLiveData = MutableLiveData<RegisterResponse>()
    val errorLiveData = MutableLiveData<String>()
    fun registerUser(registerRequest: RegisterRequest) {
        viewModelScope.launch{
            val response = userrepo.registerUser(registerRequest)
            if (response.isSuccessful) {
                regLiveData.postValue(response.body())
            } else {
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}