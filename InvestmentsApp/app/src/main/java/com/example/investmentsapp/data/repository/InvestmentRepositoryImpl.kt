package com.example.investmentsapp.data.repository

import com.example.investmentsapp.domain.model.Investment
import com.example.investmentsapp.domain.repository.InvestmentRepository
import com.example.investmentsapp.network.ApiService

class InvestmentRepositoryImpl(
    private val apiService: ApiService
) : InvestmentRepository {

    override suspend fun getInvestments(): List<Investment> {
        val response = apiService.getInvestments("Investments")
        if (response.isSuccessful) {
            return response.body()?.entities ?: emptyList()
        } else {
            throw Exception("Failed to fetch investments: ${response.code()}")
        }
    }
}
