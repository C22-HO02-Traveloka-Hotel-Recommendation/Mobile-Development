package com.company.project.traveloka.data.local.model.entitiy

import android.os.Parcelable
import com.company.project.traveloka.data.local.model.entitiy.hotel.Hotela
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class PointOfInterest(

    val id: Int,

    val hotel: Hotela,

    val interest: String,

    val createdAt: String,

    val updatedAt: String,

    ) : Parcelable
