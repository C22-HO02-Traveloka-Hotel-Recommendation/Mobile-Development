package com.company.project.traveloka.data.remote.source.repository.hotel

import com.company.project.traveloka.data.remote.model.entity.hotel.HotelResponse

interface HotelRepository {
    suspend fun findAll(): HotelResponse
}
