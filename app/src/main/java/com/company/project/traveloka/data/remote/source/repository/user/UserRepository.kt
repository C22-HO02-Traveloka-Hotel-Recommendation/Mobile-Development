package com.company.project.traveloka.data.remote.source.repository.user

import com.company.project.traveloka.data.local.model.entitiy.user.User
import com.company.project.traveloka.data.remote.model.entity.user.UserResponse

interface UserRepository {
    suspend fun getCurrentUser(token: String): UserResponse<User>
}
