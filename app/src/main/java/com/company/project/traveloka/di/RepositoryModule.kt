package com.company.project.traveloka.di

import com.company.project.traveloka.data.remote.source.repository.history.HistoryRepository
import com.company.project.traveloka.data.remote.source.repository.history.HistoryRepositoryImpl
import com.company.project.traveloka.data.remote.source.repository.hotel.HotelRepository
import com.company.project.traveloka.data.remote.source.repository.hotel.HotelRepositoryImpl
import com.company.project.traveloka.data.remote.source.repository.review.ReviewRepository
import com.company.project.traveloka.data.remote.source.repository.review.ReviewRepositoryImpl
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
    abstract fun bindHotelRepository(hotelRepositoryImpl: HotelRepositoryImpl): HotelRepository

    @Binds
    abstract fun bindUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository

    @Binds
    abstract fun bindHistoryRepository(historyRepositoryImpl: HistoryRepositoryImpl): HistoryRepository

    @Binds
    abstract fun bindReviewRepository(reviewRepositoryImpl: ReviewRepositoryImpl): ReviewRepository
}
