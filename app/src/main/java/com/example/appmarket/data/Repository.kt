package com.example.appmarket.data

import com.example.appmarket.model.Product
import kotlinx.coroutines.flow.StateFlow

interface Repository {
    val products: StateFlow<List<Product>>
    val cartItems: StateFlow<List<Product>>
    fun addToCart(id: Int)
    fun removeFromCart(id: Int)

    fun totalPrice(): Int

}