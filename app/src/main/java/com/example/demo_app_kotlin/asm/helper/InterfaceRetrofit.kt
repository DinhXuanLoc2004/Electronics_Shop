package com.example.demo_app_kotlin.asm.helper

import com.example.demo_app_kotlin.asm.httpModel.userModel.RegisterRequestModel
import com.example.demo_app_kotlin.asm.httpModel.userModel.RegisterResponseModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface InterfaceRetrofit {
    // nơi khai báo các API
    @POST("auth/register")
    fun register(@Body body: RegisterRequestModel) : Call<RegisterResponseModel>
}