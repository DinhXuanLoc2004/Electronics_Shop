package com.example.demo_app_kotlin.asm.httpModel.userModel

import com.fasterxml.jackson.annotation.JsonProperty

data class RegisterRequestModel(
    @JsonProperty("email") val email: String,
    @JsonProperty("password") val password: String,
    @JsonProperty("fullname") val fullname: String
)

data class RegisterResponseModel(
    @JsonProperty("status") val status: Boolean,
    @JsonProperty("message") val message: String,
    @JsonProperty("data") val data: data
)

    data class data(
        @JsonProperty("userId") val userId: String,
        @JsonProperty("email") val email: String,
        @JsonProperty("fullname") val fullname: String
    )