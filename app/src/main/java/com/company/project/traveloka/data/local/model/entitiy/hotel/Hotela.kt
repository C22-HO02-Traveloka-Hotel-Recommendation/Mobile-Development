package com.company.project.traveloka.data.local.model.entitiy.hotel

import android.os.Parcelable
import com.company.project.traveloka.data.local.model.entitiy.PointOfInterest
import com.company.project.traveloka.data.local.model.entitiy.facility.RoomFacility
import com.company.project.traveloka.data.local.model.entitiy.review.Review
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Hotela(
    val id: Int,

    val name: String,

    val address: String,

    val city: String,

    val country: String,

    val lat: Double,

    val lon: Double,

    val type: String,

    val image: String,

    val description: String,

    val reviews: List<Review>,

    val hotelFacilities: List<HotelFacility>,

    val pointOfInterest: List<PointOfInterest>,

    val roomFacilities: List<RoomFacility>,

    val createdAt: String,

    val updatedAt: String,
) : Parcelable
