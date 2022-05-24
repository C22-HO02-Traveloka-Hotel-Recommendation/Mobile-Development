package com.company.project.traveloka.data.local.model.entitiy.review

import android.os.Parcelable
import com.company.project.traveloka.data.local.model.entitiy.hotel.Hotela
import com.company.project.traveloka.data.local.model.entitiy.user.User
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Review(
    val id: Int?,

    val user: User?,

    val hotel: Hotela?,

    val rating: Int?,

    val comment: String?,

    val createdAt: String?,

    val updatedAt: String?,
) : Parcelable
