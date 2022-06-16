package com.company.project.traveloka.ui.home.hotel

import androidx.lifecycle.ViewModel
import com.company.project.traveloka.data.remote.source.repository.hotel.HotelRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HotelViewModel @Inject constructor(private val hotelRepository: HotelRepository) :
    ViewModel()
