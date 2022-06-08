package com.company.project.traveloka.data.remote.source.service

import com.company.project.traveloka.data.local.model.entitiy.hotel.Hotel
import com.company.project.traveloka.data.remote.model.entity.hotel.HotelResponse
import retrofit2.http.GET

interface HotelApiService {

    @GET("hotels")
    suspend fun findAll(): HotelResponse<Hotel>
}
