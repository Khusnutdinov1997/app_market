package com.example.appmarket.data

import com.example.appmarket.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor(): Repository {

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    override val products: StateFlow<List<Product>> = _products.asStateFlow()


   override fun addToCart(id: Int) {

   }

    //TODO подумать как добавить объект


}

