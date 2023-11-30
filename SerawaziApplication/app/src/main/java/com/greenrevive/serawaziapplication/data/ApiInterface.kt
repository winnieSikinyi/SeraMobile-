package com.greenrevive.serawaziapplication.data

import com.greenrevive.serawaziapplication.model.LoginRequest
import com.greenrevive.serawaziapplication.model.LoginResponse
import com.greenrevive.serawaziapplication.model.RegisterRequest
import com.greenrevive.serawaziapplication.model.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface{
    @POST("api/gamers/register/")
    suspend fun registerUser(@Body registerRequest: RegisterRequest): Response<RegisterResponse>
    @POST("api/gamers/login/")
    suspend fun loginUser(@Body loginRequest: LoginRequest):Response<LoginResponse>
}
