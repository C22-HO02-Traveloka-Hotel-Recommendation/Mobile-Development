package com.company.project.traveloka.di

import com.company.project.traveloka.data.remote.source.repository.hotel.HotelRepository
import com.company.project.traveloka.data.remote.source.repository.hotel.HotelRepositoryImpl
import com.company.project.traveloka.data.remote.source.repository.user.UserRepository
import com.company.project.traveloka.data.remote.source.repository.user.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindHotelRepository(hotelRespositoryImpl: HotelRepositoryImpl): HotelRepository

    @Binds
    abstract fun bindUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository
}
