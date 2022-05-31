package com.company.project.traveloka.data.remote.source.repository.hotel

import androidx.paging.PagingData
import com.company.project.traveloka.data.local.model.entitiy.hotel.Hotel
import kotlinx.coroutines.flow.Flow

interface HotelRepository {
    suspend fun findAll(): Flow<PagingData<Hotel>>
}
