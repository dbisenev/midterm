package com.example.tickets.model.entity

import com.google.gson.annotations.SerializedName

data class Offer(
    val id: String,
    val price: Int,
    @SerializedName("_flight")
    val flight: Flight
)