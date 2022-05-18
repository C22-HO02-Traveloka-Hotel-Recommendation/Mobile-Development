package com.company.project.traveloka.ui.profile.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.company.project.traveloka.ui.profile.fragment.PostFragment

class ProfilesPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> PostFragment()
            1 -> PostFragment()
            2 -> PostFragment()
        }
        return fragment as Fragment
    }
}
