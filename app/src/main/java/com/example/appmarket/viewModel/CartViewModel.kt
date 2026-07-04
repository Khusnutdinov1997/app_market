package com.example.appmarket.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appmarket.data.Repository
import com.example.appmarket.model.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    val products = repository.products
    val cartItems = repository.cartItems

    val totalPrice: StateFlow<Int> = repository.cartItems
        .map{ items ->
            items.sumOf { it.price }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = 0
        )

    fun addToCart(id: Int) {
        repository.addToCart(id)
    }

    fun removeFromCart(id: Int) {
        repository.removeFromCart(id)
    }


}