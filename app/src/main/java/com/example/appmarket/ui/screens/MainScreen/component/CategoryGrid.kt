package com.example.appmarket.ui.screens.MainScreen.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appmarket.R

@Composable
fun CategoryGrid(
    onHomeClick: () -> Unit,
    onSearchClick: () -> Unit,
    onCartClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CategoryItem(iconRes = R.drawable.ic_home, onClick = onHomeClick)
            CategoryItem(iconRes = R.drawable.ic_search, onClick = onSearchClick)
            CategoryItem(iconRes = R.drawable.my_icon_card, onClick = onCartClick)
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CategoryItem(iconRes = R.drawable.ic_belt, onClick ={})
            CategoryItem(iconRes = R.drawable.ic_trousers, onClick = {  })
            CategoryItem(iconRes = R.drawable.ic_shoes, onClick = {  })
        }
    }
}
@Preview(showBackground = true)
@Composable
fun CategoryGridPreview() {
    CategoryGrid(
        onHomeClick = {},
        onSearchClick = {},
        onCartClick = {}
    )
}