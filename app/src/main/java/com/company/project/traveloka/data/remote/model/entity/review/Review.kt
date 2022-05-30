package com.company.project.traveloka.data.remote.model.entity.review

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Review(

    @Json(name = "id")
    val id: Int?,

    @Json(name = "user_id")
    val userId: String?,

    @Json(name = "hotel_id")
    val hotelId: String?,

    @Json(name = "rating")
    val rating: String?,

    @Json(name = "comment")
    val comment: String?,

    @Json(name = "created_at")
    val createdAt: String?,

    @Json(name = "updated_at")
    val updatedAt: String?,
)
