package com.company.project.traveloka.data.remote.model.entity

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class BaseResponse(
    @Json(name = "status")
    val status: String?,
    @Json(name = "message")
    val message: String?
) : Parcelable
