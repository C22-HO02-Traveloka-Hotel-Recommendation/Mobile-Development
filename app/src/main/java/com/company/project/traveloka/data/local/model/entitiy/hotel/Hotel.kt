package com.company.project.traveloka.data.local.model.entitiy.hotel

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
@Entity(tableName = "hotel")
data class Hotel(
    @PrimaryKey
    val id: Int,

    val name: String,

    val star: String,

    val photoUrl: String,

    val price: Double,

    val rating: Double,

    val lat: Double,

    val lon: Double,
) : Parcelable
