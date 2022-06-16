package com.company.project.traveloka.data.remote.source.service

import com.company.project.traveloka.data.local.model.entitiy.user.User
import com.company.project.traveloka.data.remote.model.entity.user.UserResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface UserApiService {

    @GET("users/me")
    suspend fun getCurrentUser(
        @Header("Authorization") token: String,
    ): UserResponse<User>
}
