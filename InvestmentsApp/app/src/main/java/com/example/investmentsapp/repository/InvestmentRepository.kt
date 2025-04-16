package com.example.investmentsapp.repository

import com.example.investmentsapp.network.ApiService

class InvestmentRepository(
    private val apiService: ApiService
) {
    suspend fun getInvestments(keypass: String) = apiService.getInvestments(keypass)
}
