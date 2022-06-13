package com.company.project.traveloka.data.remote.source.repository.hotel

import androidx.paging.PagingData
import com.company.project.traveloka.data.local.model.entitiy.hotel.Hotel
import kotlinx.coroutines.flow.Flow

interface HotelRepository {

    suspend fun findAll(token: String): Flow<PagingData<Hotel>>

    suspend fun findByName(token: String, hotelName: String): Flow<PagingData<Hotel>>

    fun generateDummyHotel(): List<Hotel>
}
