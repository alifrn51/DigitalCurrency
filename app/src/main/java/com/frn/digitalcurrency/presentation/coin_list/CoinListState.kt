package com.frn.digitalcurrency.presentation.coin_list

import com.frn.digitalcurrency.domain.model.Coin

data class CoinListState(
    val isLoading:Boolean = false,
    val coins:List<Coin> = emptyList(),
    val error:String = ""
)
