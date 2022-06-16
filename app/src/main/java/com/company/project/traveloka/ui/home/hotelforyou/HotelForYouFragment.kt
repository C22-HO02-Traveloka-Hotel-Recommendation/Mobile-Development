package com.company.project.traveloka.ui.home.hotelforyou

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.company.project.traveloka.databinding.FragmentForYourPageBinding
import com.company.project.traveloka.ui.home.LoadingStateAdapter
import com.company.project.traveloka.ui.home.hotel.adapter.ListHotelAdapter
import com.company.project.traveloka.utils.Utils.isLoading
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job

@AndroidEntryPoint
class HotelForYouFragment : Fragment() {

    private var _binding: FragmentForYourPageBinding? = null
    private val binding get() = _binding!!
    private val hotelForYouViewModel: HotelForYouViewModel by viewModels()
    private lateinit var adapter: ListHotelAdapter
    private var job: Job = Job()

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
        isLoading(true, binding.fypProgressBar)
        Firebase.auth.currentUser?.getIdToken(false)?.addOnSuccessListener {
            Log.d("HotelForYouFragment", "firebaseAuthWithGoogle:" + it.token)
            setRecyclerView()
            setupViewModel(it.token)
        }
    }

    private fun setupViewModel(token: String?) {

        lifecycleScope.launchWhenResumed {
            if (job.isActive) job.cancel()
            hotelForYouViewModel.findAll("Bearer $token").observe(viewLifecycleOwner) { hotels ->
                adapter.submitData(lifecycle, hotels)
            }
        }
        isLoading(false, binding.fypProgressBar)
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
