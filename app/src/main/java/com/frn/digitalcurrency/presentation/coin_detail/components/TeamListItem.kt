package com.frn.digitalcurrency.presentation.coin_detail.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.frn.digitalcurrency.data.remote.dto.TeamMember

@Composable
fun TeamListItem(
    teemMember: TeamMember,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = teemMember.name,
            style = MaterialTheme.typography.h6
        )
        
        Spacer(modifier = Modifier.height(4.dp))
        
        Text(
            text = teemMember.position,
            style = MaterialTheme.typography.body2,
            fontStyle = FontStyle.Italic
        )

    }

}