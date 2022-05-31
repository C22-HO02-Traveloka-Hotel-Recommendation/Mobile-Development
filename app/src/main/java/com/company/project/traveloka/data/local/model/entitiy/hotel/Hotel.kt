package com.company.project.traveloka.data.local.model.entitiy.hotel

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
@Entity(tableName = "hotels")
data class Hotel(
    @PrimaryKey
    @Json(name = "id")
    val id: Int,

    @Json(name = "name")
    val name: String,

    @Json(name = "address")
    val address: String,

    @Json(name = "image")
    val image: String,

    @Json(name = "description")
    val description: String?,

    @Json(name = "created_at")
    val createdAt: String?,

    @Json(name = "updated_at")
    val updatedAt: String?,

    val star: Double,

    val price: Double,

    val rating: Double,

    val lat: Double,

    val lon: Double,

) : Parcelable
