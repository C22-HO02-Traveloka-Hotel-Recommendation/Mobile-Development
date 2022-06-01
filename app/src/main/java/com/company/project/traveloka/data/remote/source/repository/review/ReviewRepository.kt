package com.company.project.traveloka.data.remote.source.repository.review

import com.company.project.traveloka.data.local.model.entitiy.review.Review

interface ReviewRepository {

    fun generateDummyHistory(): List<Review>
}
