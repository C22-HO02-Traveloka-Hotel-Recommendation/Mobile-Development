package com.company.project.traveloka.data.remote.source.repository.review

import com.company.project.traveloka.data.local.model.entitiy.review.Review
import javax.inject.Inject

class ReviewRepositoryImpl @Inject constructor() : ReviewRepository {

    override fun generateDummyHistory(): List<Review> {
        TODO("Not yet implemented")
    }
}
