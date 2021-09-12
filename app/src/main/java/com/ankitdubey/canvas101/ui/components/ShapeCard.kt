package com.ankitdubey.canvas101.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ankitdubey.canvas101.CardType
import com.ankitdubey.canvas101.R
import com.ankitdubey.canvas101.cardsImage


/**
 * Created by Ankit Dubey on 16,August,2021
 *
 *
 */

@ExperimentalMaterialApi
@Composable
fun ShapeCard(
    cardType: CardType,
    onCardClicked: (CardType) -> Unit
) {

    Card(
        onClick = { onCardClicked(cardType) },
        modifier = Modifier
            .padding(8.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = cardsImage[cardType] ?: R.drawable.charts),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 8.dp, start = 6.dp, end = 0.dp)
                    .fillMaxWidth()
                    .height(80.dp)
            )
            Text(
                text = cardType.value, style = TextStyle(fontSize = 20.sp),
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}