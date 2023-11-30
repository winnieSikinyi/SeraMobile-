package com.greenrevive.serawaziapplication.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("username")var fullName:String,
    var email: String,
    @SerializedName("phone_number")var phoneNumber:String,
    var password:String,
    @SerializedName("confirm_password")var confirmPassword:String

)
