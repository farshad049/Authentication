package com.example.authentication.network

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded

interface AuthApi {

    @FormUrlEncoded
    fun login(
        @Field("email") email:String,
        @Field("password") password:String
    ):Any
}