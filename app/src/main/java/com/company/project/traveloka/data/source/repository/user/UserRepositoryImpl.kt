package com.company.project.traveloka.data.source.repository.user

import com.company.project.traveloka.data.source.service.UserApiService
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val userApiService: UserApiService) : UserRepository {
}