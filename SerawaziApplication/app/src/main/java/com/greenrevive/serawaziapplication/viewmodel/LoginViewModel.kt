package com.greenrevive.serawaziapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greenrevive.serawaziapplication.model.LoginRequest
import com.greenrevive.serawaziapplication.model.LoginResponse
import com.greenrevive.serawaziapplication.repository.LoginRepository
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel(){
    var loginRepository = LoginRepository()
    val regLiveData = MutableLiveData<LoginResponse>()
    val errLiveData = MutableLiveData<String>()
    fun Login(loginRequest: LoginRequest){
        viewModelScope.launch {
            val response = loginRepository.loginUser(loginRequest)
            if (response.isSuccessful){
                regLiveData.postValue(response.body())
            }
            else{
                errLiveData.postValue(response.errorBody()?.string())
            }
        }
    }

}