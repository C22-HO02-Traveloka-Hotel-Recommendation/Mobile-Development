package com.company.project.traveloka.data.remote.source.repository.history

import androidx.paging.PagingData
import com.company.project.traveloka.data.local.model.entitiy.history.History
import com.company.project.traveloka.data.local.model.entitiy.hotel.Hotel
import kotlinx.coroutines.flow.Flow

interface HistoryRepository {

    suspend fun findAll(): Flow<PagingData<Hotel>>

    fun generateDummyHistory(): List<History>
}
