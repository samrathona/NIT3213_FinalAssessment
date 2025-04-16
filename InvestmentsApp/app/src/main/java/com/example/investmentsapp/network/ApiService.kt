package com.example.investmentsapp.network

import com.example.investmentsapp.model.LoginRequest
import com.example.investmentsapp.model.LoginResponse
import com.example.investmentsapp.model.InvestmentEntity
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @POST("sydney/auth")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @GET("dashboard/{keypass}")
    suspend fun getInvestments(@Path("keypass") keypass: String): Response<InvestmentEntity>
}
