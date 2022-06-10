package com.company.project.traveloka.ui.home.hotel.detail

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.company.project.traveloka.R
import com.company.project.traveloka.data.local.model.entitiy.hotel.Hotel
import com.company.project.traveloka.databinding.ActivityDetailBinding
import java.util.*

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
        getSupportActionBar()?.setDisplayShowHomeEnabled(true)

        title = binding.hotelName.text.toString()
        setDetailHotel()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.details_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun setDetailHotel() {
        val hotel = intent.getParcelableExtra<Hotel>(extraHotel) as Hotel
//        val zonedDateTime = ZonedDateTime.parse(story.createdAt)
//        val dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale("id", "ID"))

        binding.apply {
            Glide.with(this@DetailActivity)
                .load(hotel.image)
                .placeholder(R.drawable.ic_block)
                .into(imageVieHotel)
            hotelName.text = hotel.name
            hotelLocation.text = StringBuilder().append(hotel.city).append(", ").append(hotel.country)
            description.text = hotel.description
        }
    }

    companion object {
        const val extraHotel = "detailHotel"
    }
}
