package com.company.project.traveloka.ui.register

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.company.project.traveloka.databinding.ActivityRegisterBinding
import com.company.project.traveloka.ui.login.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        auth = Firebase.auth

        binding.apply {
            registerText.setOnClickListener{
                startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
            }

            btnSignin.setOnClickListener {
                val email = binding.textInputEmail.text.toString()
                val pass = binding.textInputPassword.text.toString()
                val confirmPass = binding.textInputConfirmPassword.text.toString()

                if (email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()) {
                    if (pass == confirmPass) {

                        auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                            if (it.isSuccessful) {
                                val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                                startActivity(intent)
                            } else {
                                Toast.makeText(this@RegisterActivity, it.exception.toString(), Toast.LENGTH_SHORT).show()

                            }
                        }
                    } else {
                        Toast.makeText(this@RegisterActivity, "Password is not matching", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this@RegisterActivity, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()

                }
            }
        }
    }
}
