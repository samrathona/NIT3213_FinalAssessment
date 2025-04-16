package com.example.investmentsapp.domain.model

data class Investment(
    val assetType: String,
    val ticker: String,
    val currentPrice: Double,
    val description: String
)
