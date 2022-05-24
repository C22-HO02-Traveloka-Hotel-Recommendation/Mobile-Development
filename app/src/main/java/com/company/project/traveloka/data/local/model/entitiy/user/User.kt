package com.company.project.traveloka.data.local.model.entitiy.user

import android.os.Parcelable
import com.company.project.traveloka.data.local.model.entitiy.review.Review
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class User(
    val id: Int,

    val name: String,

    val email: String,

    val phone: String,

    val image: String,

    val reviews: List<Review>,

    val createdAt: String,

    val updatedAt: String,
) : Parcelable
