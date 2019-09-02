package com.example.cnnapp.network

import com.example.cnnapp.model.CnnModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ClientInterface {

    @GET("top-headlines")
    fun getNewsRecords(@Query("country") abbrCountry : String,
                       @Query("apiKey") api_key: String): Call<CnnModel>
}




