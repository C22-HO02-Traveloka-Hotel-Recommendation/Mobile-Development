package com.company.project.traveloka.ui.home.hotel.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.company.project.traveloka.ui.home.foryourpage.ForYourPageFragment
import com.company.project.traveloka.ui.home.search.SearchFragment

class SectionsPagerAdapter(
    activity: FragmentManager,
    lifecycle: Lifecycle,
) : FragmentStateAdapter(activity, lifecycle) {

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> {
                fragment = ForYourPageFragment()
            }
            1 -> {
                fragment = SearchFragment()
            }
        }
        return fragment as Fragment
    }

    override fun getItemCount(): Int = 2
}
