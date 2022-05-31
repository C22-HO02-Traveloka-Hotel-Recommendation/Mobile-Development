package com.company.project.traveloka.data.remote.model.entity.user

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(
    @Json(name = "id")
    val id: Long?,

    @Json(name = "name")
    val name: String?,

    @Json(name = "email")
    val email: String?,

    @Json(name = "phone")
    val phone: String?,

    @Json(name = "image")
    val image: String?,

    @Json(name = "created_at")
    val createdAt: String?,

    @Json(name = "updated_at")
    val updatedAt: String?,
)
