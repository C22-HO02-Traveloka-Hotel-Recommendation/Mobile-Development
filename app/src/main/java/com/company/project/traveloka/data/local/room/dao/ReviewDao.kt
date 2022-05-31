package com.company.project.traveloka.data.local.room.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.company.project.traveloka.data.local.model.entitiy.review.Review

@Dao
interface ReviewDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReview(review: List<Review>)

    @Query("SELECT * FROM reviews")
    fun findAll(): PagingSource<Int, Review>

    @Query("DELETE FROM hotels")
    suspend fun deleteAll()
}