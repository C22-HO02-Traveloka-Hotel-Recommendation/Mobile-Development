package com.company.project.traveloka.ui.profile

import androidx.lifecycle.ViewModel
import com.company.project.traveloka.data.local.model.entitiy.user.User
import com.company.project.traveloka.data.remote.model.entity.user.UserResponse
import com.company.project.traveloka.data.remote.source.repository.user.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val userRepository: UserRepository) :
    ViewModel() {

    suspend fun getCurrentUser(token: String): UserResponse<User> {
        return userRepository.getCurrentUser(token)
    }
}
