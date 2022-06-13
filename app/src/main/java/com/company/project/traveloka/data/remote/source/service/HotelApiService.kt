package com.company.project.traveloka.data.remote.source.service

import com.company.project.traveloka.data.local.model.entitiy.hotel.Hotel
import com.company.project.traveloka.data.remote.model.entity.hotel.HotelResponse
import com.company.project.traveloka.utils.constant.NETWORK_LOAD_SIZE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface HotelApiService {

    @GET("hotels")
    suspend fun findAll(
        @Header("Authorization") token: String,
        @Query("limit") page: Int = 5,
        @Query("offset") size: Int = NETWORK_LOAD_SIZE
    ): HotelResponse<Hotel>

    @GET("hotels")
    suspend fun findByName(
        @Header("Authorization") token: String,
        @Query("limit") hotelName: String,
//        @Query("offset") size: Int = NETWORK_LOAD_SIZE
    ): HotelResponse<Hotel>
}
