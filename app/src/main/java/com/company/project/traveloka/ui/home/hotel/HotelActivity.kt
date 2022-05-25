package com.company.project.traveloka.ui.home.hotel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.company.project.traveloka.data.model.hotel.Hotel
import com.company.project.traveloka.databinding.ActivityHotelBinding
import com.company.project.traveloka.ui.home.hotel.adapter.ListHotelAdapter

class HotelActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHotelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHotelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerViewHome.layoutManager = LinearLayoutManager(this)
        val adapter = ListHotelAdapter()
        adapter.setStoryList(generateDummyHotel())
        binding.recyclerViewHome.adapter = adapter
    }

    fun generateDummyHotel(): List<Hotel> {
        val hotelList = ArrayList<Hotel>()
        for (i in 1..10) {
            val hotel = Hotel(
                i,
                "The Sultan Hotel & Residence Jakarta\n",
                "4",
                "https://sultanjakarta.com/data/upload/images/d28c4f7445d31fd6da6b0d89660d2489_crop_920x530.jpg",
                123123.123,
                4.8,
                -16.002,
                -16.002,
            )
            hotelList.add(hotel)
        }
        return hotelList
    }
}
