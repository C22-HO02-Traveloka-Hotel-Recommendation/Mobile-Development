package com.company.project.traveloka.ui.profile

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.company.project.traveloka.R
import com.company.project.traveloka.databinding.ActivityProfileBinding
import com.company.project.traveloka.ui.profile.adapter.ProfilesPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileActivity : AppCompatActivity() {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.tab_text_post,
            R.string.tab_text_review,
            R.string.tab_text_koleksi
        )
    }

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        //val profilesPagerAdapter = ProfilesPagerAdapter(this)
        binding.apply {
            //viewpagerProfile.adapter = profilesPagerAdapter
           // TabLayoutMediator(tabProfile, viewpagerProfile) { tab, position ->
           //     tab.text = resources.getString(TAB_TITLES[position])
           // }.attach()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.share -> {
                Toast.makeText(this, "Fitur belum dibuat", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.help -> {
                Toast.makeText(this, "Fitur belum dibuat", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.home_menu -> {
                Toast.makeText(this, "Fitur belum dibuat", Toast.LENGTH_SHORT).show()
                return true
            }
            else -> return true
        }
    }
}
