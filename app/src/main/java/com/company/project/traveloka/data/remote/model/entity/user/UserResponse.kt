package com.company.project.traveloka.data.remote.model.entity.user

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserResponse<T>(
    @Json(name = "status")
    val status: String?,

    @Json(name = "message")
    val message: String?,

    @Json(name = "data")
    val data: List<T>? = listOf(),
)
