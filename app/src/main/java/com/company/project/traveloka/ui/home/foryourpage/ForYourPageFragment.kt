package com.company.project.traveloka.ui.home.foryourpage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.company.project.traveloka.databinding.FragmentForYourPageBinding
import com.company.project.traveloka.ui.home.hotel.HotelViewModel
import com.company.project.traveloka.ui.home.hotel.adapter.ListHotelAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForYourPageFragment : Fragment() {

    private var _binding: FragmentForYourPageBinding? = null
    private val binding get() = _binding!!
    private val forYourPageViewModel: ForYourPageViewModel by viewModels()
    private val hotelViewModel: HotelViewModel by viewModels()

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
        setHotel()
    }

    private fun setHotel() {
        binding.recyclerViewHome.layoutManager = LinearLayoutManager(activity)
        val adapter = ListHotelAdapter()
        adapter.setStoryList(hotelViewModel.generateDummyHotel())
        binding.recyclerViewHome.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
