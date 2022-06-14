package com.company.project.traveloka.data.remote.source.service

import com.company.project.traveloka.data.local.model.entitiy.review.Review
import com.company.project.traveloka.data.remote.model.entity.review.ReviewResponse
import retrofit2.http.GET

interface ReviewApiService {

    @GET("reviews")
    suspend fun findAll(): ReviewResponse<Review>
//
//    @GET("reviews")
//    suspend fun findAll(): ReviewResponse<Review>
}
