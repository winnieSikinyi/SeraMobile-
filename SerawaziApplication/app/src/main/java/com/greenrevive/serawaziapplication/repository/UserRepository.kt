package com.greenrevive.serawaziapplication.repository

import androidx.lifecycle.MutableLiveData
import com.greenrevive.serawaziapplication.data.ApiInterface
import com.greenrevive.serawaziapplication.model.RegisterRequest
import com.greenrevive.serawaziapplication.model.RegisterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    val regLiveData = MutableLiveData<RegisterResponse>()
    val errorLiveData = MutableLiveData<String>()
    val apiClient = ApiClient.buildClient(ApiInterface::class.java)

    //    fun registerUser(registerRequest: RegisterRequest) {
//        viewModelScope.launch{
//            val response = userrepo.registerUser(registerRequest)
//            if (response.isSuccessful) {
//                regLiveData.postValue(response.body())
//            } else {
//                errorLiveData.postValue(response.errorBody()?.string())
//            }
//        }
//    }
    suspend fun registerUser(registerRequest: RegisterRequest): Response<RegisterResponse> {
    return withContext(Dispatchers.IO){
        apiClient.registerUser(registerRequest)
    }
}
}