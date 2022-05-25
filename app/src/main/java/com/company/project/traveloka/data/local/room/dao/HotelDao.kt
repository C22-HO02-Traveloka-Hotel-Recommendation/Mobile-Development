package com.company.project.traveloka.data.local.room.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.company.project.traveloka.data.local.model.entitiy.hotel.Hotel

@Dao
interface HotelDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHotel(hotel: List<Hotel>)

    @Query("SELECT * FROM hotel")
    fun findAll(): PagingSource<Int, Hotel>

    @Query("DELETE FROM hotel")
    suspend fun deleteAll()
}
