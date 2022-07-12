package com.example.authentication.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

class RemoteDataSource {

    val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()

    fun <Api> buildApi(api: Class<Api>):Api{
        return Retrofit.Builder()
            .baseUrl("https://apix.simplifiedcoding.in/api/auth/login")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(api)
    }
}