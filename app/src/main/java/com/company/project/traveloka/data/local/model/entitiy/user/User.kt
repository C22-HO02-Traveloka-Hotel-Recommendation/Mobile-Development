package com.company.project.traveloka.data.local.model.entitiy.user

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
@Entity(tableName = "users")
data class User(
    @PrimaryKey
    @Json(name = "id")
    val id: Int?,

    @Json(name = "name")
    val name: String?,

    @Json(name = "email")
    val email: String?,

    @Json(name = "description")
    val phone: String?,

    @Json(name = "image")
    val image: String?,

    @Json(name = "created_at")
    val createdAt: String?,

    @Json(name = "updated_at")
    val updatedAt: String?,
) : Parcelable
