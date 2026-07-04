package com.example.appmarket.ui.screens.MainScreen.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appmarket.model.Product
import com.example.appmarket.R
import com.example.appmarket.model.Size

@Composable
fun RowList(
    products: List<Product>,
    modifier: Modifier = Modifier,
    onProductClick: (Int) -> Unit
) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
       items(products){ product ->

        ProductImageCard(
            product = product,
            onClick = { onProductClick(product.id)},
            modifier = Modifier.width(160.dp)
        )
       }
    }
}

@Preview(showBackground = true)
@Composable
fun RowlistPreview() {
    val dummyProducts = listOf(
        Product(1, R.drawable.img, "Navy KROOKED sweater", "Hand-woven cotton", 1750,
            Size.M),
        Product(2, R.drawable.img, "Grey Longsleeve", "Comfortable grey cotton", 1200,
            Size.L),
        Product(3, R.drawable.img, "Vans Venice", "Classic vans collection", 2500,
            Size.S)
    )

    RowList(
        products = dummyProducts,
        onProductClick = {},
        modifier = Modifier
    )
}