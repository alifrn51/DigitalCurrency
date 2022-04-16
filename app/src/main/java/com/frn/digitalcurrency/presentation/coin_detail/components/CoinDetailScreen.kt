package com.frn.digitalcurrency.presentation.coin_detail.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.frn.digitalcurrency.presentation.coin_detail.CoinDetailViewModel
import com.frn.digitalcurrency.presentation.ui.theme.Green
import com.frn.digitalcurrency.presentation.ui.theme.Red
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun CoinDetailScreen(
    viewModel: CoinDetailViewModel = hiltViewModel()
) {

    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize().padding(20.dp)) {
        state.coin?.let { coin ->
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {

                item {


                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = "${coin.rank}: ${coin.name} (${coin.symbol})",
                            style = MaterialTheme.typography.h4,
                            modifier = Modifier.weight(8f)
                        )

                        Text(
                            text = if (coin.isActive) "active" else "inactive",
                            style = MaterialTheme.typography.body2,
                            textAlign = TextAlign.Center,
                            color = if (coin.isActive) Green else Red,
                            fontStyle = FontStyle.Italic,
                            modifier = Modifier.weight(2f)
                        )

                    }

                    Spacer(modifier = Modifier.height(15.dp))

                    Text(
                        text = coin.description,
                        textAlign = TextAlign.Start,
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    Text(
                        text = "Tags",
                        style = MaterialTheme.typography.h5,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    FlowRow(
                        mainAxisSpacing = 10.dp,
                        crossAxisSpacing = 10.dp,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        coin.tags?.let {
                            it.forEach { tag ->
                                CoinTag(tag = tag)
                            }
                        }

                    }




                }

                coin.team?.let {
                    if(coin.team.isNotEmpty()){
                        item {

                            Spacer(modifier = Modifier.height(15.dp))

                            Text(
                                text = "Team members",
                                style = MaterialTheme.typography.h5,
                                modifier = Modifier.fillMaxWidth()
                            )

                            Spacer(modifier = Modifier.height(15.dp))

                        }
                        items(coin.team) { teamMember ->


                            TeamListItem(
                                teemMember = teamMember,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp)
                            )
                            Divider()
                        }
                    }

                }



            }
        }

        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp)
                    .align(alignment = Alignment.Center)
            )
        }

        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .align(alignment = Alignment.Center)
            )
        }
    }


}