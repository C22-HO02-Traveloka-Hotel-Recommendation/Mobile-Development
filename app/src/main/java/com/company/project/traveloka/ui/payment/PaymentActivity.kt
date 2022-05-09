package com.company.project.traveloka.ui.payment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.company.project.traveloka.databinding.ActivityPaymentBinding

class PaymentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPaymentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
