package com.company.project.traveloka.ui.home.search

import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.company.project.traveloka.R
import com.company.project.traveloka.databinding.FragmentSearchBinding
import com.google.android.material.datepicker.MaterialDatePicker
import java.util.*

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private val searchViewModel: SearchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        (activity as AppCompatActivity?)!!.title = "Search"
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()

        binding.datePickerText.setOnClickListener {
            // Initiation date picker with
            // MaterialDatePicker.Builder.datePicker()
            // and building it using build()
            val datePicker = MaterialDatePicker.Builder.dateRangePicker().build()
            datePicker.show(childFragmentManager, "DatePicker")

            // Setting up the event for when ok is clicked
            datePicker.addOnPositiveButtonClickListener {
                // formatting date in dd-mm-yyyy format.
                val dateFormatter = SimpleDateFormat("EEE, dd MMM yyyy", Locale.US)
                val dateFirst = dateFormatter.format(Date(it.first))
                val dateSecond = dateFormatter.format(Date(it.second))
                binding.datePickerText.hint = "$dateFirst - $dateSecond"
                Toast.makeText(context, "$dateFirst $dateSecond is selected", Toast.LENGTH_LONG).show()
            }

            // Setting up the event for when cancelled is clicked
            datePicker.addOnNegativeButtonClickListener {
                Toast.makeText(context, "${datePicker.headerText} is cancelled", Toast.LENGTH_LONG).show()
            }

            // Setting up the event for when back button is pressed
            datePicker.addOnCancelListener {
                Toast.makeText(context, "Date Picker Cancelled", Toast.LENGTH_LONG).show()
            }
        }

        binding.filledButton.setOnClickListener {
            NavHostFragment
                .findNavController(this)
                .navigate(R.id.action_navigation_home_to_hotelActivity)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
