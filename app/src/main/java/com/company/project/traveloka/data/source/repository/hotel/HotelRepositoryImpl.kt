package com.company.project.traveloka.data.source.repository.hotel

import com.company.project.traveloka.data.source.service.HotelApiService
import javax.inject.Inject

class HotelRepositoryImpl @Inject constructor(private val hotelApiService: HotelApiService) : HotelRepository
