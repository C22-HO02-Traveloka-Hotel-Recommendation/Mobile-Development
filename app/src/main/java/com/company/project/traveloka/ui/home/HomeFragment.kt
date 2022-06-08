package com.company.project.traveloka.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.company.project.traveloka.R
import com.company.project.traveloka.databinding.FragmentHomeBinding
import com.company.project.traveloka.ui.home.hotel.adapter.SectionsPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity?)!!.title = "Home"
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()

        setViewPager()
    }

    private fun setViewPager() {

        val viewPager: ViewPager2? = view?.findViewById(R.id.view_pager)
        val tabs: TabLayout? = view?.findViewById(R.id.tabs)

        val sectionsPagerAdapter = SectionsPagerAdapter(childFragmentManager, lifecycle)

        viewPager?.adapter = sectionsPagerAdapter
        if (viewPager != null && tabs != null) {
            TabLayoutMediator(tabs, viewPager) { tab, position ->
                tab.text = resources.getString(TAB_TITLES[position])
            }.attach()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.hotelForYou,
            R.string.search
        )
    }
}
