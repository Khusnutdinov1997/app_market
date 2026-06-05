package com.example.appmarket.viewModel

import androidx.lifecycle.ViewModel
import com.example.appmarket.data.Repository
import com.example.appmarket.model.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    val products = repository.products
    val cartItems = repository.cartItems

    fun addToCart(id: Int) {
        repository.addToCart(id)
    }

    fun removeFromCart(id: Int) {
        repository.removeFromCart(id)
    }

    fun totalPrice(): Int {
        return repository.totalPrice()
    }
}