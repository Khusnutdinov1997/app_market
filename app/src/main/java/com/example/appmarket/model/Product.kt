package com.example.appmarket.model

data class Product(
    val id: Int,
    val imageURl: Int,
    val label: String,
    val overView: String,
    val price: Int,
    val size: Size
)
