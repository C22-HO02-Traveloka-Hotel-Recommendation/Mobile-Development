package com.company.project.traveloka.data.model.hotel

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Hotel(
    @Json(name = "id")
    val id: Int = 0
) : Parcelable
