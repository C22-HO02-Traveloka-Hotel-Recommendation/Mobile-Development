package com.company.project.traveloka.ui.home.hotel

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.company.project.traveloka.databinding.ActivityHotelBinding
import com.company.project.traveloka.ui.home.hotel.adapter.ListHotelAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HotelActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHotelBinding
    private val hotelViewModel: HotelViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHotelBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Hotel"

        binding.recyclerViewHome.layoutManager = LinearLayoutManager(this)
        val adapter = ListHotelAdapter()
        adapter.setStoryList(hotelViewModel.generateDummyHotel())
        binding.recyclerViewHome.adapter = adapter
    }
}
