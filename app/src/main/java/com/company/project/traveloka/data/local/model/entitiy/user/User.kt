package com.company.project.traveloka.data.local.model.entitiy.user

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Entity(tableName = "user")
@Parcelize
data class User(
    @PrimaryKey
    val id: Int,

    val name: String,

    val email: String,

    val phone: String,

    val image: String,

//    val reviews: List<Review>,

    val createdAt: String,

    val updatedAt: String,
) : Parcelable
