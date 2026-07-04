package com.example.appmarket.ui.screens.cartScreen.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CartBottomBar(
    totalPrice: Int
) {
    Column(modifier = Modifier.padding(16.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Итого:",
                style = MaterialTheme.typography.titleMedium
            )
            Text("$totalPrice руб.", style = MaterialTheme.typography.titleLarge)
        }
        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth()
        )
        {
            Text(text = "Оформить заказ")
        }
    }
}