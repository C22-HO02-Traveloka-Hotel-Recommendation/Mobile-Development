package com.company.project.traveloka.ui.home.hotel

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.company.project.traveloka.data.local.model.entitiy.hotel.Hotel
import com.company.project.traveloka.databinding.ActivityHotelBinding
import com.company.project.traveloka.ui.home.hotel.adapter.HotelSearchAdapter
import com.company.project.traveloka.ui.home.hotelforyou.HotelForYouViewModel
import com.company.project.traveloka.utils.Utils.isLoading
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job

@AndroidEntryPoint
class HotelActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHotelBinding
    private val hotelForYouViewModel: HotelForYouViewModel by viewModels()
    private var job: Job = Job()
    private lateinit var adapter: HotelSearchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHotelBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Hotel"

        val searchValue = intent?.getStringExtra(searchValue).toString()

        Firebase.auth.currentUser?.getIdToken(false)?.addOnSuccessListener {
            Log.d("HotelForYouFragment", "firebaseAuthWithGoogle:" + it.token)
            setupViewModel(it.token, searchValue)
            isLoading(false, binding.hotelProgressBar)
        }
    }

    private fun setupViewModel(token: String?, searchValue: String) {
        isLoading(true, binding.hotelProgressBar)
        binding.recyclerViewHome.layoutManager = LinearLayoutManager(this)
        lifecycleScope.launchWhenResumed {
            if (job.isActive) job.cancel()
            val hotels: List<Hotel>? = hotelForYouViewModel.findByNameOrCity(
                "Bearer $token",
                searchValue
            ).data
            adapter = HotelSearchAdapter(hotels)
            binding.recyclerViewHome.adapter = adapter
        }
    }

    companion object {
        const val searchValue = "searchValue"
    }
}
