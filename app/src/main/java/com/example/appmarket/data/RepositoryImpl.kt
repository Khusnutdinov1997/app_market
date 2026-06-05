package com.example.appmarket.data

import com.example.appmarket.model.Product
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton


class RepositoryImpl @Inject constructor(): Repository {

    private val _product = MutableStateFlow<List<Product>>(emptyList())
    override val products: StateFlow<List<Product>> = _product.asStateFlow()


   override fun addToCard(id: Int) {
       _product.value = _product.value
   }

    //TODO подумать как добавить объект


}

