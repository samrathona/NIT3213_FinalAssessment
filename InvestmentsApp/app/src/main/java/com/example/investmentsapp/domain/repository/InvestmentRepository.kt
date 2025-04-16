package com.example.investmentsapp.domain.repository

import com.example.investmentsapp.domain.model.Investment

interface InvestmentRepository {
    suspend fun getInvestments(): List<Investment>
}
