package com.example.investmentsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.investmentsapp.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Fetch data from intent
        val assetType = intent.getStringExtra("assetType")
        val ticker = intent.getStringExtra("ticker")
        val price = intent.getDoubleExtra("currentPrice", 0.0)
        val description = intent.getStringExtra("description")

        // Bind data to UI
        binding.txtAssetType.text = assetType
        binding.txtTicker.text = ticker
        binding.txtPrice.text = "$$price"
        binding.txtDescription.text = description
    }
}
