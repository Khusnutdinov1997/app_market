package com.example.appmarket.ui.screens

import android.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.appmarket.model.Product
import com.example.appmarket.model.Size
import com.example.appmarket.viewModel.CartViewModel

@Composable
fun CartScreen(
    viewModel: CartViewModel = hiltViewModel(),
) {
    val items by viewModel.cartItems.collectAsState()

    CartContent(
        items = items,
        onRemove = { id -> viewModel.removeFromCart(id) },
        totalPrice = viewModel.totalPrice()
    )
}

@Composable
fun CartContent(
    items: List<Product>,
    onRemove: (Int) -> Unit,
    totalPrice: Int
) {
    Scaffold(
        topBar = {
            Text(
                text = "Корзина",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .systemBarsPadding()
                    .padding(16.dp, top = 16.dp, end = 16.dp, bottom = 0.dp)
            )
        },
        bottomBar = {
            CartBottomBar(
                totalPrice = totalPrice
            )
        }
    ) { paddingValues ->

        if (items.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Корзина пуста. Добавьте товар."
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier.padding(paddingValues)
            ) {
                items(items) { product ->
                    CartItemRow(product, onRemove)
                }
            }
        }
    }
}

@Composable
fun CartItemRow(
    product: Product,
    onRemove: (Int) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = product.label,
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = "${product.price} руб.",
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Button(
                onClick = { onRemove(product.id) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red
                )
            ) {
                Text(
                    text = "Удалить"
                )
            }
        }
    }
}

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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CartPreview(modifier: Modifier = Modifier) {
    val fakeItems = listOf(
        Product(1, 0, "Кроссовки", "Описание", 5000, size = Size.M),
        Product(2, 0, "Худи", "Описание", 3500, size = Size.S)
    )
    val fakeItemsEmpty = emptyList<Product>()

    MaterialTheme() {
        CartContent(
            items = fakeItems,
            onRemove = {},
            totalPrice = 3434
        )
    }
}