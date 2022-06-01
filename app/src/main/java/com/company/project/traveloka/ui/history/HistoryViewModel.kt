package com.company.project.traveloka.ui.history

import androidx.lifecycle.ViewModel
import com.company.project.traveloka.data.local.model.entitiy.history.History
import com.company.project.traveloka.data.remote.source.repository.history.HistoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val historyRepository: HistoryRepository
) : ViewModel() {

    fun generateDummyHistory(): List<History> {
        return historyRepository.generateDummyHistory()
    }
}
