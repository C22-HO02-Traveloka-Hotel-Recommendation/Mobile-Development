package com.company.project.traveloka.data.local.model.entitiy.facility

import android.os.Parcelable
import androidx.room.PrimaryKey
import com.company.project.traveloka.data.local.model.entitiy.hotel.Hotela
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class RoomFacility(
    @PrimaryKey
    val id: Int,

    val hotel: Hotela,

    val facility: String,

    val createdAt: String,

    val updatedAt: String,
) : Parcelable
