package com.example.appmarket.ui.screens.MainScreen.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appmarket.R
import com.example.appmarket.model.Product
import com.example.appmarket.model.Size


@Composable
fun ProductCard(
    modifier: Modifier = Modifier,
    product: Product,
    onAddToCart:  (Product) -> Unit
) {
    var selectedSize by remember { mutableStateOf<String?>(product.size.name) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(32.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(15.dp),
                border = BorderStroke(1.dp, color = Color.LightGray.copy(alpha = 0.5f))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    contentScale = ContentScale.Fit
                )
            }

            Text(text =product.label, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Text(
                text = product.overView,
                color = Color.Gray,
                maxLines = 2
            )
            Text(
                text = "R ${product.price}",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    listOf("S", "M", "L").forEach { size ->
                        SizeCircle(
                            text = size,
                            isSelected = selectedSize == size,
                            onClick = {
                                selectedSize = if (selectedSize == size) null else size
                            }
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .background(Color(0xFF565555), CircleShape)
                        .clickable{onAddToCart(product)},
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.my_icon_card),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(23.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF808080)
@Composable
fun ProductCardPreview(
) {
    val dummyProduct = Product(
        id = 1,
        imageURl = R.drawable.img, // Убедись, что картинка с таким именем есть в drawable
        label = "Navy KROOKED sweater",
        overView = "Hand-woven 100% cotton KROOKED rugby jearsey in baby blue/navy retro colour way.",
        price = 1750,
        size = Size.M
    )

    Box(
        modifier = Modifier.padding(16.dp)
    ) {
        ProductCard(product = dummyProduct, onAddToCart = {})
    }
}

@Composable
fun SizeCircle(
    text: String,
    isSelected: Boolean = false,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .size(36.dp)
            .clip(CircleShape)
            .background(
                if (isSelected) Color(0xFF313131) else Color(0xFF676767),
                CircleShape
            )
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White
        )
    }
}