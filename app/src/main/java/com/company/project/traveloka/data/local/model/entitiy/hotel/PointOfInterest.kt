package com.company.project.traveloka.data.local.model.entitiy.hotel

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class PointOfInterest(
    @Json(name = "id")
    var id: Int?,

    @Json(name = "hotelId")
    var hotelId: String?,

    @Json(name = "facility")
    var facility: String?
) : Parcelable
