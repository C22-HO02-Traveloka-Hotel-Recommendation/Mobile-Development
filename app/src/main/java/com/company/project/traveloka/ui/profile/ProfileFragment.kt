package com.company.project.traveloka.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.company.project.traveloka.R
import com.company.project.traveloka.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()

        // val profilesPagerAdapter = ProfilesPagerAdapter(this)
        binding.apply {
            // viewpagerProfile.adapter = profilesPagerAdapter
            // TabLayoutMediator(tabProfile, viewpagerProfile) { tab, position ->
            //     tab.text = resources.getString(TAB_TITLES[position])
            // }.attach()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.share -> {
                Toast.makeText(context, "Fitur belum dibuat", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.help -> {
                Toast.makeText(context, "Fitur belum dibuat", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.home_menu -> {
                Toast.makeText(context, "Fitur belum dibuat", Toast.LENGTH_SHORT).show()
                true
            }
            else -> true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.tab_text_post,
            R.string.tab_text_review,
            R.string.tab_text_koleksi
        )
    }
}
