package com.frn.digitalcurrency.domain.repository

import com.frn.digitalcurrency.data.remote.dto.CoinDetailDto
import com.frn.digitalcurrency.data.remote.dto.CoinDto
import com.frn.digitalcurrency.domain.model.Coin

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}