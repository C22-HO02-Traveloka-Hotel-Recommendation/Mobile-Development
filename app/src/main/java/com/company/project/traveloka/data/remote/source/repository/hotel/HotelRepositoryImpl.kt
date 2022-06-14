package com.company.project.traveloka.data.remote.source.repository.hotel

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.company.project.traveloka.data.local.model.entitiy.hotel.Hotel
import com.company.project.traveloka.data.local.model.entitiy.review.Review
import com.company.project.traveloka.data.local.paging.HotelPagingSource
import com.company.project.traveloka.data.remote.model.entity.review.ReviewResponse
import com.company.project.traveloka.data.remote.source.service.HotelApiService
import com.company.project.traveloka.utils.Constant.NETWORK_LOAD_SIZE
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HotelRepositoryImpl @Inject constructor(
    private val hotelApiService: HotelApiService
) :
    HotelRepository {

    override suspend fun findAll(token: String): Flow<PagingData<Hotel>> = Pager(
        config = PagingConfig(pageSize = NETWORK_LOAD_SIZE),
        pagingSourceFactory = {
            HotelPagingSource(
                token,
                apiService = hotelApiService
            )
        }
    ).flow

    override suspend fun findByName(token: String, hotelName: String): Flow<PagingData<Hotel>> =
        Pager(
            config = PagingConfig(pageSize = NETWORK_LOAD_SIZE),
            pagingSourceFactory = {
                HotelPagingSource(
                    token,
                    apiService = hotelApiService,
                    hotelName
                )
            }
        ).flow

    override suspend fun findHotelReviewsByHotelId(
        token: String,
        id: String
    ): ReviewResponse<Review> {
        return hotelApiService.findHotelReviewsByHotelId(token, id)
    }

    override fun generateDummyHotel(): List<Hotel> {
        val hotelList = ArrayList<Hotel>()
        for (i in 1..10) {
            val hotel = Hotel(
                "{$i}",
                "Sugar Maple Inn",
                "8546 Edgemont Rd",
                "Higden",
                "AR",
                "US",
                35.6,
                -92.2,
                "Hotel",
                "https://sultanjakarta.com/data/upload/images/d28c4f7445d31fd6da6b0d89660d2489_crop_920x530.jpg",
                325000,
                0,
                "The standard check-in time is 12:00 PM and the standard check-out time is 12:00 PM. Early check-in or late check-out is strictly subjected to availability and may be chargeable by the hotel. Any early check-in or late check-out request must be directed and reconfirmed with hotel directly",
                null,
                null,
                null
            )
            hotelList.add(hotel)
        }
        return hotelList
    }
}
