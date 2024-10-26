package com.example.tickets.model.network

import com.example.tickets.model.service.OfferService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://my-json-server.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    /**
     * think about performing network request
     */

    val client = retrofit.create(OfferService::class.java)

}