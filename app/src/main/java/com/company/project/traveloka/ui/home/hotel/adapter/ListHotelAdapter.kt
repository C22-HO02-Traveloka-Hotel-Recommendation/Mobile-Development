package com.company.project.traveloka.ui.home.hotel.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.company.project.traveloka.R
import com.company.project.traveloka.data.local.model.entitiy.hotel.Hotel
import com.company.project.traveloka.databinding.ItemRowHotelBinding

class ListHotelAdapter :
    RecyclerView.Adapter<ListHotelAdapter.HotelViewHolder>() {

    private var hotels: List<Hotel>? = null

    fun setStoryList(hotels: List<Hotel>?) {
        this.hotels = hotels
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): HotelViewHolder {
        val view =
            ItemRowHotelBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return HotelViewHolder(view)
    }

    override fun onBindViewHolder(holder: HotelViewHolder, position: Int) {
        val data = hotels!![position]
        holder.bind(data)
    }

    class HotelViewHolder(private val binding: ItemRowHotelBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(hotel: Hotel) {

//            val zonedDateTime = ZonedDateTime.parse(story.createdAt)
//            val dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale("id", "ID"))

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
                tvStar.text = hotel.star.toString()
                tvLocation.text = "Jakarta"
                tvRating.text = hotel.rating.toString()
                tvPrice.text = hotel.price.toString()
            }
        }
    }

    override fun getItemCount(): Int = hotels?.size!!
}
