package com.company.project.traveloka.data.model.user

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class User(
    @Json(name = "id")
    val id: Int = 0
) : Parcelable
