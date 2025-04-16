package com.example.investmentsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.investmentsapp.adapter.InvestmentAdapter
import com.example.investmentsapp.databinding.ActivityDashboardBinding
import com.example.investmentsapp.domain.model.Investment
import com.example.investmentsapp.network.RetrofitClient
import kotlinx.coroutines.launch

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val keypass = intent.getStringExtra("KEYPASS") ?: return

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {
            try {
                val response = RetrofitClient.apiService.getInvestments(keypass)
                if (response.isSuccessful && response.body() != null) {
                    val entities = response.body()!!.entities

                    // ✅ Convert InvestmentEntity to Investment
                    val investments = entities.map {
                        Investment(
                            assetType = it.assetType,
                            ticker = it.ticker,
                            currentPrice = it.currentPrice,
                            description = it.description
                        )
                    }

                    // ✅ Set adapter with click
                    binding.recyclerView.adapter = InvestmentAdapter(investments) { item ->
                        val intent = Intent(this@DashboardActivity, DetailsActivity::class.java)
                        intent.putExtra("assetType", item.assetType)
                        intent.putExtra("ticker", item.ticker)
                        intent.putExtra("currentPrice", item.currentPrice)
                        intent.putExtra("description", item.description)
                        startActivity(intent)
                    }

                } else {
                    Toast.makeText(this@DashboardActivity, "Failed to load data", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Toast.makeText(this@DashboardActivity, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
