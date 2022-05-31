package com.company.project.traveloka.data.remote.source.service

import com.company.project.traveloka.data.local.model.entitiy.hotel.Hotel
import com.company.project.traveloka.data.remote.model.entity.hotel.HotelResponse
import com.company.project.traveloka.utils.constant.NETWORK_LOAD_SIZE
import retrofit2.http.GET
import retrofit2.http.Query

interface HotelApiService {

    @GET("hotels")
    suspend fun findAll(
        @Query("page") page: Int = 1,
        @Query("size") size: Int = NETWORK_LOAD_SIZE,
//        @Header("Authorization") token: String,
        @Query("location") location: Int = 1
    ): HotelResponse<Hotel>
}
