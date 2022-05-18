package com.company.project.traveloka.data.model.hotel

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Hotel(
    val id: Int,

    val name: String,

    val star: String,

    val photoUrl: String,

    val price: Double,

    val rating: Double,

    val lat: Double,

    val lon: Double,
) : Parcelable
