package com.frn.digitalcurrency.presentation.coin_detail

import com.frn.digitalcurrency.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)