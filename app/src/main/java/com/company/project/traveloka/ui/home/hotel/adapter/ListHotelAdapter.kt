package com.company.project.traveloka.ui.home.hotel.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.company.project.traveloka.R
import com.company.project.traveloka.data.local.model.entitiy.hotel.Hotel
import com.company.project.traveloka.databinding.ItemRowHotelBinding
import com.company.project.traveloka.ui.home.hotel.detail.DetailActivity

class ListHotelAdapter :
    PagingDataAdapter<Hotel, ListHotelAdapter.HotelViewHolder>(Comparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelViewHolder = HotelViewHolder(
        binding = ItemRowHotelBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: HotelViewHolder, position: Int) {

        val data = getItem(position)
        if (data != null) {
            holder.bind(data)
        }
    }

    inner class HotelViewHolder(private val binding: ItemRowHotelBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(hotel: Hotel) {

            binding.apply {
                Glide.with(itemView)
                    .load(hotel.image)
                    .placeholder(R.drawable.ic_block)
                    .into(imgItemPhoto)
                tvName.text = hotel.name
                val price = hotel.price?.div(1000)
                tvPrice.text = StringBuilder().append("Rp").append(price).append("k /Night")
                tvRating.text = StringBuilder().append(hotel.stars.toString()).append(" Star")
                tvType.text = hotel.type
                tvCity.text = hotel.city
            }

            itemView.setOnClickListener {

                val intent = Intent(itemView.context, DetailActivity::class.java)
                intent.putExtra(DetailActivity.extraHotel, hotel)
                itemView.context.startActivity(intent)
            }
        }
    }

    private object Comparator : DiffUtil.ItemCallback<Hotel>() {
        override fun areItemsTheSame(oldItem: Hotel, newItem: Hotel): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: Hotel, newItem: Hotel): Boolean =
            oldItem.description == newItem.description
    }
}
