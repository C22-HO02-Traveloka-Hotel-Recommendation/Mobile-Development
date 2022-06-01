package com.company.project.traveloka.data.remote.source.repository.hotel

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.company.project.traveloka.data.local.model.entitiy.hotel.Hotel
import com.company.project.traveloka.data.local.paging.HotelPagingSource
import com.company.project.traveloka.data.local.room.database.HotelDatabase
import com.company.project.traveloka.data.remote.source.service.HotelApiService
import com.company.project.traveloka.utils.constant.NETWORK_LOAD_SIZE
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HotelRepositoryImpl @Inject constructor(
    private val hotelDatabase: HotelDatabase,
    private val hotelApiService: HotelApiService
) :
    HotelRepository {

    override suspend fun findAll(): Flow<PagingData<Hotel>> = Pager(
        config = PagingConfig(pageSize = NETWORK_LOAD_SIZE, enablePlaceholders = false),
        pagingSourceFactory = {
            HotelPagingSource(
                apiService = hotelApiService
            )
        }
    ).flow

    override fun generateDummyHotel(): List<Hotel> {
        val hotelList = ArrayList<Hotel>()
        for (i in 1..10) {
            val hotel = Hotel(
                i,
                "The Sultan Hotel & Residence Jakarta\n",
                "4",
                "https://sultanjakarta.com/data/upload/images/d28c4f7445d31fd6da6b0d89660d2489_crop_920x530.jpg",
                "test",
                "test",
                "test",
                4.8,
                123123.123,
                4.8,
                -16.002,
                -16.002,
            )
            hotelList.add(hotel)
        }
        return hotelList
    }
}
