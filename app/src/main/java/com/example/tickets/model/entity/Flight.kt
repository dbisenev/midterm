package com.example.tickets.model.entity

import com.google.gson.annotations.SerializedName

/**
 * think about json deserialization considering case format
 */
data class Flight(
    @SerializedName("departureLoc")
    val departureLocation: Location,
    @SerializedName("arrivalLoc")
    val arrivalLocation: Location,
    val departureTimeInfo: String,
    val arrivalTimeInfo: String,
    val flightNumber: String,
    @SerializedName("air")
    val airline: Airline,
    val duration: Int
)