package com.example.investmentsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.investmentsapp.databinding.ActivityLoginBinding
import com.example.investmentsapp.model.LoginRequest
import com.example.investmentsapp.network.RetrofitClient
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString().trim()
            val studentId = binding.etStudentId.text.toString().trim()

            if (username.isNotEmpty() && studentId.isNotEmpty()) {
                performLogin(username, studentId)
            } else {
                Toast.makeText(this, "Please enter both fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun performLogin(username: String, studentId: String) {
        val request = LoginRequest(username, studentId)

        lifecycleScope.launch {
            try {
                val response = RetrofitClient.apiService.login(request)

                if (response.isSuccessful && response.body() != null) {
                    val keypass = response.body()!!.keypass

                    // ✅ Show keypass in TextView
                    binding.tvLoginStatus.text = getString(R.string.login_success_keypass, keypass)

                    // ⏳ Delay for 1.5 seconds before moving to Dashboard
                    binding.root.postDelayed({
                        val intent = Intent(this@LoginActivity, DashboardActivity::class.java)
                        intent.putExtra("KEYPASS", keypass.toString())
                        startActivity(intent)
                        finish()
                    }, 1500)
                } else {
                    binding.tvLoginStatus.text = getString(R.string.login_failed)
                }
            } catch (e: Exception) {
                binding.tvLoginStatus.text = getString(R.string.login_error, e.message)

            }
        }
    }
}
