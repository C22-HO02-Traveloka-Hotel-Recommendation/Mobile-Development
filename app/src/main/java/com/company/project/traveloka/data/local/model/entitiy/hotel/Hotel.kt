package com.company.project.traveloka.data.local.model.entitiy.hotel

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Hotel(
    @Json(name = "id")
    val id: String,

    @Json(name = "name")
    val name: String,

    @Json(name = "address")
    val address: String,

    @Json(name = "city")
    val city: String,

    @Json(name = "state")
    val state: String,

    @Json(name = "country")
    val country: String,

    @Json(name = "latitude")
    val latitude: Double,

    @Json(name = "longitude")
    val longitude: Double,

    @Json(name = "type")
    val type: String,

    @Json(name = "image")
    val image: String?,

    @Json(name = "price")
    val price: Long?,

    @Json(name = "stars")
    val stars: Int?,

    @Json(name = "description")
    val description: String?,

    @Json(name = "hotelFacilities")
    val hotelFacilities: List<HotelFacility>?,

    @Json(name = "pointOfInterests")
    val pointOfInterests: List<PointOfInterest>?,

    @Json(name = "roomFacilities")
    val roomFacilities: List<RoomFacility>?,
) : Parcelable
