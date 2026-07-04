package com.example.appmarket.ui.screens.productScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.appmarket.ui.screens.MainScreen.component.ProductCard
import com.example.appmarket.viewModel.CartViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(
    productId: Int,
    viewModel: CartViewModel = hiltViewModel(),
    onBackClick: () -> Unit
) {
    val products by viewModel.products.collectAsState(initial = emptyList())

    val product = products.find { it.id == productId }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Детали товара") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = null)
                    }
                }
            )
        }
    ) { paddingValues ->
        product?.let { item ->
            Box(modifier = Modifier.padding(paddingValues)) {
                ProductCard(
                    product = item,
                    onAddToCart = { viewModel.addToCart(item.id) }
                )
            }
        } ?: Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Товар не найден")
        }
    }
}