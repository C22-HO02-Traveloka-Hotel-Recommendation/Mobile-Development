package com.company.project.traveloka.data.remote.source.repository.hotel

import androidx.paging.PagingData
import com.company.project.traveloka.data.local.model.entitiy.hotel.Hotel
import com.company.project.traveloka.data.local.model.entitiy.review.Review
import com.company.project.traveloka.data.remote.model.entity.hotel.HotelResponse
import com.company.project.traveloka.data.remote.model.entity.review.ReviewResponse
import kotlinx.coroutines.flow.Flow

interface HotelRepository {

    suspend fun findAll(token: String): Flow<PagingData<Hotel>>

    suspend fun findRecommendationHotel(token: String): HotelResponse<Hotel>

    suspend fun findByNameOrCity(token: String, hotelName: String): HotelResponse<Hotel>

    suspend fun findHotelReviewsByHotelId(token: String, id: String): ReviewResponse<Review>

    fun generateDummyHotel(): List<Hotel>
}
