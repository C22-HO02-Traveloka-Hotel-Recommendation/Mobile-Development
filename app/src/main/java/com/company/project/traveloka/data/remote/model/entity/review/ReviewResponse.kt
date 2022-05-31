package com.company.project.traveloka.data.remote.model.entity.review

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ReviewResponse<T>(

    @Json(name = "status")
    val status: String?,

    @Json(name = "message")
    val message: String?,

    @Json(name = "data")
    val data: List<T>? = listOf(),
)
