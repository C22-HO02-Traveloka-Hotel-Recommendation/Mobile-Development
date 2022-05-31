package com.company.project.traveloka.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.company.project.traveloka.data.local.model.entitiy.hotel.Hotel
import com.company.project.traveloka.data.remote.source.repository.hotel.HotelRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val hotelRepository: HotelRepository
) : ViewModel() {

    suspend fun findAll(): LiveData<PagingData<Hotel>> {
        return hotelRepository.findAll().cachedIn(viewModelScope).asLiveData()
    }
}
