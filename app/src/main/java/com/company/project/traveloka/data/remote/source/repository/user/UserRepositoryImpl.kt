package com.company.project.traveloka.data.remote.source.repository.user

import com.company.project.traveloka.data.remote.source.service.UserApiService
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val userApiService: UserApiService) : UserRepository
