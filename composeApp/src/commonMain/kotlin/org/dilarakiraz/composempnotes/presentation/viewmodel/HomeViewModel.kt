package org.dilarakiraz.composempnotes.presentation.viewmodel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.dilarakiraz.composempnotes.data.model.Product
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import org.dilarakiraz.composempnotes.data.repository.HomeRepository

class HomeViewModel : ViewModel() {

    private val _products = MutableStateFlow<List<Product>>(listOf())
    val products = _products.asStateFlow()

    private val homeRepository = HomeRepository()
    private var allProducts: List<Product> = listOf()

    init {
        viewModelScope.launch {
            homeRepository.getProducts().collect { products ->
                allProducts = products
                _products.value = allProducts
               // _products.update { it + products }
            }
        }
    }

    fun searchProducts(query: String) {
        _products.value = allProducts.filter {
            it.title?.contains(query, ignoreCase = true) == true
        }
    }

    fun clearSearch() {
        _products.value = allProducts
    }
}