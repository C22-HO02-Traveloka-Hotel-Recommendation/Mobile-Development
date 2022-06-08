package com.company.project.traveloka.ui.home.hotel.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.company.project.traveloka.R
import com.company.project.traveloka.data.local.model.entitiy.hotel.Hotel
import com.company.project.traveloka.databinding.ItemRowHotelBinding

class ListHotelAdapter :
    PagingDataAdapter<Hotel, ListHotelAdapter.HotelViewHolder>(Comparator) {

    private var hotels: List<Hotel>? = null

    fun setStoryList(hotels: List<Hotel>?) {
        this.hotels = hotels
    }

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

//            val zonedDateTime = ZonedDateTime.parse(story.createdAt)
//            val dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale("id", "ID"))
//
//            itemView.setOnClickListener {
//                val intent = Intent(itemView.context, DetailActivity::class.java)
//                intent.putExtra(DetailActivity.extraStory, story)
//
//                val optionsCompat: ActivityOptionsCompat =
//                    ActivityOptionsCompat.makeSceneTransitionAnimation(
//                        itemView.context as Activity,
//                        Pair(binding.imgItemPhoto, "storyImage"),
//                        Pair(binding.tvName, "name"),
//                        Pair(binding.tvDate, "date"),
//                        Pair(binding.tvDescription, "description"),
//                    )
//                itemView.context.startActivity(intent, optionsCompat.toBundle())
//            }

            binding.apply {
                Glide.with(itemView)
                    .load(hotel.image)
                    .placeholder(R.drawable.ic_block)
                    .into(imgItemPhoto)
                tvName.text = hotel.name
                tvType.text = hotel.type
                tvCity.text = hotel.city
                //                tvRating.text = hotel.rating.toString()
                //                tvPrice.text = hotel.price.toString()
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
