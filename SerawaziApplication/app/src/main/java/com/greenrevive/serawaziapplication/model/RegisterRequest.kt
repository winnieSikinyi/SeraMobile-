package com.greenrevive.serawaziapplication.model

import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    @SerializedName("username") var fullName: String,
    var email: String,
    var password: String,
    @SerializedName("confirm_password") var passwordConfirm:String,
    @SerializedName("phone_number") var phoneNumber:String,






    )
