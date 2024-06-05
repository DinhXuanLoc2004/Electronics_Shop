package com.example.demo_app_kotlin.asm.helper

import android.util.Log
import com.example.demo_app_kotlin.asm.httpModel.userModel.RegisterRequestModel
import com.example.demo_app_kotlin.asm.httpModel.userModel.RegisterResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitAPI {
    private  val retrofit = RetrofitClient.getClient()
    private  val interfaceRetrofit = retrofit.create(InterfaceRetrofit::class.java)

    fun register(body: RegisterRequestModel,
                 callback: (RegisterResponseModel?) -> Unit){
        interfaceRetrofit.register(body).enqueue(
            object : Callback<RegisterResponseModel> {
                override fun onResponse(call: Call<RegisterResponseModel>,
                                        response: Response<RegisterResponseModel>
                ) {
                    if (response.isSuccessful) {
                        val registerResponseModel = response.body()
                        callback(registerResponseModel)
                    } else {
                        Log.d(">>>Failed to register", response.message())
                    }
                }

                override fun onFailure(call: Call<RegisterResponseModel>, t: Throwable) {
                    Log.d("Failed to register", t.message ?: "Unknown error")
                }
            })
    }
}