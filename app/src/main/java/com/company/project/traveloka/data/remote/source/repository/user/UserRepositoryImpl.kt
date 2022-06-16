package com.company.project.traveloka.data.remote.source.repository.user

import com.company.project.traveloka.data.local.model.entitiy.user.User
import com.company.project.traveloka.data.remote.model.entity.user.UserResponse
import com.company.project.traveloka.data.remote.source.service.UserApiService
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val userApiService: UserApiService) :
    UserRepository {
    override suspend fun getCurrentUser(token: String): UserResponse<User> {
        return userApiService.getCurrentUser(token)
    }
}
