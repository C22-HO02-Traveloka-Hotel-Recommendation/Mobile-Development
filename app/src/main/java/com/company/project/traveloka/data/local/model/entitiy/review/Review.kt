package com.company.project.traveloka.data.local.model.entitiy.review

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
@Entity(tableName = "reviews")
data class Review(
    @PrimaryKey
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
) : Parcelable
