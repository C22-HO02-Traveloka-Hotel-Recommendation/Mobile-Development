package com.company.project.traveloka.ui.home.hotel.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.company.project.traveloka.ui.home.hotelforyou.HotelForYouFragment
import com.company.project.traveloka.ui.home.search.SearchFragment

class SectionsPagerAdapter(
    activity: FragmentManager,
    lifecycle: Lifecycle,
) : FragmentStateAdapter(activity, lifecycle) {

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> {
                fragment = HotelForYouFragment()
            }
            1 -> {
                fragment = SearchFragment()
            }
        }
        return fragment as Fragment
    }

    override fun getItemCount(): Int = 2
}
