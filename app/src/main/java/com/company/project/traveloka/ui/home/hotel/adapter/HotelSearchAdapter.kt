package com.company.project.traveloka.ui.home.hotel.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.company.project.traveloka.R
import com.company.project.traveloka.data.local.model.entitiy.hotel.Hotel
import com.company.project.traveloka.databinding.ItemSearchHotelBinding
import com.company.project.traveloka.ui.home.hotel.detail.DetailActivity

class HotelSearchAdapter(private val listHotel: List<Hotel>?) :
    RecyclerView.Adapter<HotelSearchAdapter.HotelViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): HotelViewHolder {
        val binding =
            ItemSearchHotelBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return HotelViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HotelViewHolder, position: Int) {
        val hotel = listHotel?.get(position)
        if (hotel != null) {
            holder.bind(hotel)
        }
    }

    override fun getItemCount() = listHotel!!.size

    inner class HotelViewHolder(var binding: ItemSearchHotelBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(hotel: Hotel) {
            binding.apply {
                Glide.with(itemView)
                    .load(hotel.image)
                    .placeholder(R.drawable.ic_block)
                    .into(imgItemPhoto)
                tvName.text = hotel.name
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
}
