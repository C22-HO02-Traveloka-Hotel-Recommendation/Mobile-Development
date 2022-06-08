package com.company.project.traveloka.ui.home.hotelforyou

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.company.project.traveloka.data.remote.model.entity.BaseResponse
import com.company.project.traveloka.databinding.FragmentForYourPageBinding
import com.company.project.traveloka.ui.home.LoadingStateAdapter
import com.company.project.traveloka.ui.home.hotel.HotelViewModel
import com.company.project.traveloka.ui.home.hotel.adapter.ListHotelAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job

@AndroidEntryPoint
class HotelForYouFragment : Fragment() {

    private var _binding: FragmentForYourPageBinding? = null
    private val binding get() = _binding!!
    private val hotelForYouViewModel: HotelForYouViewModel by viewModels()
    private val hotelViewModel: HotelViewModel by viewModels()
    private var response: BaseResponse? = null
//    private val hotelAdapter: ListHotelAdapter by lazy { ListHotelAdapter() }
    private lateinit var adapter: ListHotelAdapter

    private var job: Job = Job()

//    private val launchPostStory =
//        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
//            if (it.resultCode == RESULT_OK) {
//                response = it.data?.getParcelableExtra(POST_STORY_RESPONSE)
//            }
//        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentForYourPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        (activity as AppCompatActivity?)!!.title = "Test"
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
        setRecyclerView()
        setupViewModel()
    }

    private fun setupViewModel() {

        lifecycleScope.launchWhenResumed {
            if (job.isActive) job.cancel()
            val adapter = ListHotelAdapter()
            binding.recyclerForYourHotel.adapter = adapter
            hotelForYouViewModel.findAll().observe(viewLifecycleOwner) { hotels ->
//                adapter.setStoryList(hotels)
                adapter.submitData(lifecycle, hotels)
            }
        }
    }

    private fun setRecyclerView() {
        binding.recyclerForYourHotel.layoutManager = LinearLayoutManager(context)
        adapter = ListHotelAdapter()
        binding.recyclerForYourHotel.adapter = adapter.withLoadStateFooter(
            footer = LoadingStateAdapter {
                adapter.retry()
            }
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
