package com.company.project.traveloka.ui.home.hotelforyou

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.company.project.traveloka.data.local.model.entitiy.hotel.Hotel
import com.company.project.traveloka.data.local.model.entitiy.review.Review
import com.company.project.traveloka.data.remote.model.entity.hotel.HotelResponse
import com.company.project.traveloka.data.remote.model.entity.review.ReviewResponse
import com.company.project.traveloka.data.remote.source.repository.hotel.HotelRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HotelForYouViewModel @Inject constructor(private val hotelRepository: HotelRepository) :
    ViewModel() {

    suspend fun findAll(token: String): LiveData<PagingData<Hotel>> {
        return hotelRepository.findAll(token).cachedIn(viewModelScope).asLiveData()
    }

    suspend fun findByNameOrCity(token: String, hotelName: String): HotelResponse<Hotel> {
        return hotelRepository.findByNameOrCity(token, hotelName)
    }

    suspend fun findHotelReviewsByHotelId(token: String, id: String): ReviewResponse<Review> {
        return hotelRepository.findHotelReviewsByHotelId(token, id)
    }

    suspend fun findHotelRecommendationHotel(token: String, id: String): HotelResponse<Hotel> {
        return hotelRepository.findRecommendationHotel(token)
    }
}
