package com.greenrevive.serawaziapplication.repository

import com.greenrevive.serawaziapplication.data.ApiInterface
import com.greenrevive.serawaziapplication.model.LoginRequest
import com.greenrevive.serawaziapplication.model.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class LoginRepository {
    val apiClient = ApiClient.buildClient(ApiInterface::class.java)
    suspend fun loginUser(loginRequest: LoginRequest): Response<LoginResponse> {
        return withContext(Dispatchers.IO){
            apiClient.loginUser(loginRequest)
        }
    }
}