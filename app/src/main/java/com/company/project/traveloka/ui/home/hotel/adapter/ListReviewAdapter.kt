package com.company.project.traveloka.ui.home.hotel.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.company.project.traveloka.data.local.model.entitiy.review.Review
import com.company.project.traveloka.databinding.ItemRowReviewBinding

class ListReviewAdapter(private val listHotelReview: List<Review>?) :
    RecyclerView.Adapter<ListReviewAdapter.ReviewViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ReviewViewHolder {
        val binding =
            ItemRowReviewBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ReviewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        val review = listHotelReview?.get(position)
        if (review != null) {
            holder.bind(review)
        }
    }

    override fun getItemCount() = listHotelReview!!.size

    inner class ReviewViewHolder(var binding: ItemRowReviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(review: Review) {
            binding.apply {
                tvName.text = StringBuilder().append("Abc***")
                tvRating.text = StringBuilder().append("Rating: ").append(review.rating)
                tvComment.text = review.comment
            }
        }
    }
}
