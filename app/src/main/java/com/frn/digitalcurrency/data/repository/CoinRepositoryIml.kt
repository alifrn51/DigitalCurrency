package com.frn.digitalcurrency.data.repository

import com.frn.digitalcurrency.data.remote.CoinPaprikaApi
import com.frn.digitalcurrency.data.remote.dto.CoinDetailDto
import com.frn.digitalcurrency.data.remote.dto.CoinDto
import com.frn.digitalcurrency.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryIml @Inject constructor(
    private val api: CoinPaprikaApi
): CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}