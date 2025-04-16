package com.example.investmentsapp.model

import com.example.investmentsapp.domain.model.Investment

data class InvestmentEntity(
    val entities: List<Investment>,
    val entityTotal: Int
)
