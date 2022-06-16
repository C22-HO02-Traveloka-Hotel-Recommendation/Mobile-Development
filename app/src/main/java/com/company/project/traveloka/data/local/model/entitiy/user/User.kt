package com.company.project.traveloka.data.local.model.entitiy.user

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class User(
    @Json(name = "id")
    val id: String?,

    @Json(name = "firebaseId")
    val firebaseId: String?,

    @Json(name = "name")
    val name: String?,

    @Json(name = "city")
    val city: String?,

    @Json(name = "state")
    val state: String?,
) : Parcelable
