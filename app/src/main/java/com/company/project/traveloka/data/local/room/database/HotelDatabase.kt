package com.company.project.traveloka.data.local.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.company.project.traveloka.data.local.model.entitiy.hotel.Hotel
import com.company.project.traveloka.data.local.model.entitiy.review.Review
import com.company.project.traveloka.data.local.model.entitiy.user.User
import com.company.project.traveloka.data.local.room.dao.HotelDao
import com.company.project.traveloka.data.local.room.dao.ReviewDao
import com.company.project.traveloka.data.local.room.dao.UserDao

@Database(
    entities = [User::class, Hotel::class, Review::class],
    version = 1,
    exportSchema = false
)
abstract class HotelDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun hotelDao(): HotelDao
    abstract fun reviewDao(): ReviewDao
}
