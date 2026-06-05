package com.example.appmarket.data

import com.example.appmarket.model.Product
import com.example.appmarket.model.Size
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor() : Repository {

    private val _products = MutableStateFlow<List<Product>>(
        listOf(
            Product(
                id = 1,
                imageURl = 0,
                label = "Кроссовки",
                overView = "Описание товара...",
                price = 5000,
                size = Size.S
            ),
            Product(
                id = 2,
                imageURl = 0,
                label = "Худи",
                overView = "Описание товара...",
                price = 2000,
                size = Size.M
            ),
            Product(
                id = 3,
                imageURl = 0,
                label = "Джинсы",
                overView = "Описание товара...",
                price = 3000,
                size = Size.S
            ),
            Product(
                id = 4,
                imageURl = 0,
                label = "Футболка",
                overView = "Описание товара...",
                price = 1000,
                size = Size.L
            ),
        )
    )
    override val products: StateFlow<List<Product>> = _products.asStateFlow()

    private val _cartItems = MutableStateFlow<List<Product>>(
        listOf(
            Product(
                id = 1,
                imageURl = 0,
                label = "Кроссовки",
                overView = "Описание товара...",
                price = 5000,
                size = Size.S
            ),
            Product(
                id = 2,
                imageURl = 0,
                label = "Худи",
                overView = "Описание товара...",
                price = 2000,
                size = Size.M
            ),
            Product(
                id = 3,
                imageURl = 0,
                label = "Джинсы",
                overView = "Описание товара...",
                price = 3000,
                size = Size.S
            ),
            Product(
                id = 4,
                imageURl = 0,
                label = "Футболка",
                overView = "Описание товара...",
                price = 1000,
                size = Size.L
            ),
        )
    )
    override val cartItems: StateFlow<List<Product>> = _cartItems.asStateFlow()


    override fun addToCart(id: Int) {
        val productToAdd = _products.value.find { it.id == id }

        productToAdd?.let { product ->
            if (!_cartItems.value.contains(product)) {
                _cartItems.value = _cartItems.value + product
            }
        }
    }

    override fun removeFromCart(id: Int) {
        _cartItems.value = _cartItems.value.filter { it.id != id }
    }

    override fun totalPrice(): Int {
        val currentCart = _cartItems.value
        val total = currentCart.sumOf { it.price }
        return total
    }
}

