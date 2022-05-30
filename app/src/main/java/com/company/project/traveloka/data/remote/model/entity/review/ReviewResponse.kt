package com.company.project.traveloka.data.remote.model.entity.review

import com.company.project.traveloka.data.local.model.entitiy.review.Review
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ReviewResponse(

    @Json(name = "status")
    val status: String?,

    @Json(name = "message")
    val message: String?,

    @Json(name = "data")
    val data: List<Review>?,
)
