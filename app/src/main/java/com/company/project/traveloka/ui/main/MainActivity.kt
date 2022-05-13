package com.company.project.traveloka.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.company.project.traveloka.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        supportActionBar?.hide()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
