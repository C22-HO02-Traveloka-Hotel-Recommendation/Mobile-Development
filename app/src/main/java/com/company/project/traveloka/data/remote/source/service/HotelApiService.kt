package com.company.project.traveloka.data.remote.source.service

import com.company.project.traveloka.data.local.model.entitiy.hotel.Hotel
import com.company.project.traveloka.data.local.model.entitiy.review.Review
import com.company.project.traveloka.data.remote.model.entity.hotel.HotelResponse
import com.company.project.traveloka.data.remote.model.entity.review.ReviewResponse
import com.company.project.traveloka.utils.Constant.NETWORK_LOAD_SIZE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface HotelApiService {

    @GET("hotels")
    suspend fun findAll(
        @Header("Authorization") token: String,
        @Query("limit") page: Int = 5,
        @Query("offset") size: Int = NETWORK_LOAD_SIZE
    ): HotelResponse<Hotel>

    @GET("hotels")
    suspend fun findByNameOrCity(
        @Header("Authorization") token: String,
        @Query("search") hotelName: String,
        @Query("limit") page: Int = 15,
        @Query("offset") size: Int = 15
    ): HotelResponse<Hotel>

    @GET("hotels/{id}/reviews")
    suspend fun findHotelReviewsByHotelId(
        @Header("Authorization") token: String,
        @Path("id") id: String
    ): ReviewResponse<Review>
}
