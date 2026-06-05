package com.example.appmarket.data

import com.example.appmarket.model.Product
import kotlinx.coroutines.flow.StateFlow

interface Repository {
    val products: StateFlow<List<Product>>

    fun addToCard(id: Int)

}