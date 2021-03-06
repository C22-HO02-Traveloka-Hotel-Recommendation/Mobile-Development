package com.company.project.traveloka.data.local.model.entitiy.review

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Review(
    @Json(name = "id")
    val id: String?,

    @Json(name = "user_id")
    val userId: String?,

    @Json(name = "hotel_id")
    val hotelId: String?,

    @Json(name = "rating")
    val rating: String?,

    @Json(name = "comment")
    val comment: String?
) : Parcelable
