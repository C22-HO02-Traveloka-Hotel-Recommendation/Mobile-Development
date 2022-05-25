package com.company.project.traveloka.data.model.history

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class History(
    val id: Int,

    val bookingId: Long,

    val date: String,

    val productName: String,

    val status: String,

    val price: Double,
) : Parcelable
