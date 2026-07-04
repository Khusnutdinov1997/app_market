package com.example.appmarket.ui.screens.MainScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.appmarket.R
import com.example.appmarket.model.Product
import com.example.appmarket.model.Size
import com.example.appmarket.ui.screens.Screens
import com.example.appmarket.ui.screens.MainScreen.component.BannerComponent
import com.example.appmarket.ui.screens.MainScreen.component.CategoryGrid
import com.example.appmarket.ui.screens.MainScreen.component.MainTopBar
import com.example.appmarket.ui.screens.MainScreen.component.RowList
import com.example.appmarket.ui.screens.MainScreen.component.SectionHeader
import com.example.appmarket.viewModel.CartViewModel

@Composable
fun MainScreen(
    navController: NavController,
    viewModel: CartViewModel = hiltViewModel()
) {
    val products by viewModel.products.collectAsState(initial = emptyList())

    MainScreenContent(
        products = products,
        onProductClick = { id ->
            navController.navigate(Screens.ProductDetail.passId(id))
        },
        onHomeClick = {
            navController.navigate(Screens.MainScreen.route)
        },
        onSearchClick = {},
        onCartClick = {
            navController.navigate(Screens.CartScreen.route)
        }
    )
}

@Composable
fun MainScreenContent(
    products: List<Product>,
    onProductClick: (Int) -> Unit,
    onHomeClick: () -> Unit,
    onSearchClick: () -> Unit,
    onCartClick: () -> Unit
) {
    Scaffold(
        topBar = {
            MainTopBar(onCartClick = onCartClick)
        }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            contentPadding = PaddingValues(bottom = 32.dp)
        ) {
            item {
                SectionHeader(title = "New arrivals")
                RowList(
                    products = products,
                    onProductClick = onProductClick
                )
            }

            item {
                SectionHeader(title = "Vans Venice collection")
                BannerComponent(imageRes = R.drawable.banner_1)
            }

            item {
                SectionHeader(title = "Shop by category")
                CategoryGrid(
                    onHomeClick = onHomeClick,
                    onSearchClick = onSearchClick,
                    onCartClick = onCartClick
                    )
            }

            item {
                SectionHeader(title = "Best sellers")
                RowList(
                    products = products,
                    onProductClick = onProductClick
                )
            }

            item {
                SectionHeader(title = "Vans Wayvee drop")
                BannerComponent(imageRes = R.drawable.banner_2)
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MainScreenPreview() {
    val dummyProducts = listOf(
        Product(
            1, R.drawable.img, "Navy KROOKED", "Description", 1750,
            Size.M
        ),
        Product(
            2, R.drawable.img_1, "Grey Sweater", "Description", 1200,
            Size.L
        ),
        Product(
            3, R.drawable.img_2, "Navy KROOKED", "Description", 1750,
            Size.M
        ),
        Product(
            4, R.drawable.img_3, "Navy KROOKED", "Description", 1750,
            Size.M
        ),
        Product(
            5, R.drawable.img_4, "Navy KROOKED", "Description", 1750,
            Size.M
        ),
    )
    MaterialTheme {
        MainScreenContent(
            products = dummyProducts,
            onProductClick = {},
            onHomeClick = {},
            onSearchClick = {},
            onCartClick = {},
        )
    }
}