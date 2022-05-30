package com.company.project.traveloka.data.local.model.entitiy.hotel

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class HotelFacility(
    val id: Int,

    val hotel: Hotela,

    val facility: String,

    val createdAt: String,

    val updatedAt: String,
) : Parcelable
