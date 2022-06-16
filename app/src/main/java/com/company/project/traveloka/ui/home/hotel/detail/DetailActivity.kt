package com.company.project.traveloka.ui.home.hotel.detail

import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.bumptech.glide.Glide
import com.company.project.traveloka.R
import com.company.project.traveloka.data.local.model.entitiy.hotel.Hotel
import com.company.project.traveloka.data.local.model.entitiy.review.Review
import com.company.project.traveloka.databinding.ActivityDetailBinding
import com.company.project.traveloka.ui.home.hotel.adapter.ListReviewAdapter
import com.company.project.traveloka.ui.home.hotel.swiper.SwiperAdapter
import com.company.project.traveloka.ui.home.hotelforyou.HotelForYouViewModel
import com.company.project.traveloka.utils.Utils.isLoading
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val hotelForYouViewModel: HotelForYouViewModel by viewModels()
    private var hotelId: String = ""
    private var job: Job = Job()
    private lateinit var recommendationAdapter: SwiperAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
        getSupportActionBar()?.setDisplayShowHomeEnabled(true)

        title = binding.hotelName.text.toString()
        isLoading(true, binding.detailProgressBar)
        setDetailHotel()
        Firebase.auth.currentUser?.getIdToken(false)?.addOnSuccessListener {

            Log.d("HotelForYouFragment", "firebaseAuthWithGoogle:" + it.token)
            setReviewHotel(it.token, hotelId)
        }
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

        hotelId = hotel.id
        binding.apply {
            Glide.with(this@DetailActivity)
                .load(hotel.image)
                .placeholder(R.drawable.ic_block)
                .into(imageVieHotel)
            hotelName.text = hotel.name
            hotelLocation.text =
                StringBuilder().append(hotel.city).append(", ").append(hotel.country)
            description.text = hotel.description
        }
    }

    private fun setReviewHotel(token: String?, hotelId: String) {

        binding.rvReview.layoutManager = LinearLayoutManager(this)
        lifecycleScope.launchWhenResumed {
            if (job.isActive) job.cancel()
            val review: List<Review>? = hotelForYouViewModel.findHotelReviewsByHotelId(
                "Bearer $token",
                hotelId
            ).data
            val adapter = ListReviewAdapter(review)
            binding.rvReview.adapter = adapter

            val hotels: List<Hotel> =
                hotelForYouViewModel.findHotelRecommendationHotel(
                    "Bearer $token",
                    id = "asd"
                ).data!!
            recommendationAdapter = SwiperAdapter(hotels, applicationContext)
            val viewPager: ViewPager = binding.viewPager
            viewPager.adapter = recommendationAdapter
            viewPager.setPadding(0, 0, 130, 0)

            viewPager.addOnPageChangeListener(object : OnPageChangeListener {
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                }

                override fun onPageSelected(position: Int) {}
                override fun onPageScrollStateChanged(state: Int) {}
            })
        }
        isLoading(false, binding.detailProgressBar)
    }

    companion object {
        const val extraHotel = "detailHotel"
    }
}
