package com.company.project.traveloka.di

import android.content.Context
import androidx.room.Room
import com.company.project.traveloka.data.local.room.dao.HotelDao
import com.company.project.traveloka.data.local.room.dao.UserDao
import com.company.project.traveloka.data.local.room.database.HotelDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideUserDao(hotelDatabase: HotelDatabase): UserDao = hotelDatabase.userDao()

    @Provides
    fun provideHotelDao(hotelDatabase: HotelDatabase): HotelDao = hotelDatabase.hotelDao()

    @Provides
    @Singleton
    fun provideHotelDatabase(@ApplicationContext context: Context): HotelDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            HotelDatabase::class.java,
            "hotels.db"
        ).build()
    }
}
