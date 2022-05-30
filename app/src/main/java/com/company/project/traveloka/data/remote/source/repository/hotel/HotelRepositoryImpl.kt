package com.company.project.traveloka.data.remote.source.repository.hotel

import com.company.project.traveloka.data.remote.model.entity.hotel.HotelResponse
import com.company.project.traveloka.data.remote.source.service.HotelApiService
import javax.inject.Inject

class HotelRepositoryImpl @Inject constructor(private val hotelApiService: HotelApiService) :
    HotelRepository {

    override suspend fun findAll(): HotelResponse {
        TODO("Not yet implemented")
    }
}
