package com.company.project.traveloka.data.remote.source.repository.history

import androidx.paging.PagingData
import com.company.project.traveloka.data.local.model.entitiy.history.History
import com.company.project.traveloka.data.local.model.entitiy.hotel.Hotel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HistoryRepositoryImpl @Inject constructor() : HistoryRepository {

    override suspend fun findAll(): Flow<PagingData<Hotel>> {
        TODO("Not yet implemented")
    }

    override fun generateDummyHistory(): List<History> {
        val historyList = ArrayList<History>()
        for (i in 1..10) {
            val history = History(
                i,
                123456,
                "Kamis, 19 May 2022",
                "The Sultan Hotel & Residence Jakarta (The Sultan Hotel & Residence)\n",
                "Purchase Success",
                123456.123
            )
            historyList.add(history)
        }
        return historyList
    }
}
