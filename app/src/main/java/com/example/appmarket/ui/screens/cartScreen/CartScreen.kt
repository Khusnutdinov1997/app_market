package com.example.appmarket.ui.screens.cartScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.appmarket.model.Product
import com.example.appmarket.model.Size
import com.example.appmarket.ui.screens.cartScreen.component.CartBottomBar
import com.example.appmarket.ui.screens.cartScreen.component.CartItemRow
import com.example.appmarket.viewModel.CartViewModel

@Composable
fun CartScreen(
    viewModel: CartViewModel = hiltViewModel(),
) {
    val items by viewModel.cartItems.collectAsState()
    val totalPrice by viewModel.totalPrice.collectAsState()
    CartContent(
        items = items,
        onRemove = { id -> viewModel.removeFromCart(id) },
        totalPrice = totalPrice
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