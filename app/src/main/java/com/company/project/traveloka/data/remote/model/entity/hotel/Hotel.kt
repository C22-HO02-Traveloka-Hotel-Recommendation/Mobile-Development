package com.company.project.traveloka.data.remote.model.entity.hotel

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Hotel(
    @Json(name = "id")
    val id: Int?,

    @Json(name = "name")
    val name: String?,

    @Json(name = "image")
    val image: String?,

    @Json(name = "description")
    val description: String?,

    @Json(name = "created_at")
    val createdAt: String?,

    @Json(name = "updated_at")
    val updatedAt: String?,
)
