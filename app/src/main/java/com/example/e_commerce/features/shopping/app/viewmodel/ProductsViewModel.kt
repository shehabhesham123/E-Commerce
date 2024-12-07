package com.example.e_commerce.features.shopping.app.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.e_commerce.core.interactor.Usecase
import com.example.e_commerce.core.platform.BasicViewModel
import com.example.e_commerce.features.shopping.app.model.Product
import com.example.e_commerce.features.shopping.domain.interactor.GetAllProducts
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "ProductsViewModel"

@HiltViewModel
class ProductsViewModel @Inject constructor(private val getProductsUseCase: GetAllProducts) :
    BasicViewModel() {
    var products by mutableStateOf<List<Product>>(emptyList())
        private set

    fun getProducts() {
        viewModelScope.launch {
            getProductsUseCase(Usecase.None).fold(::handleFailure, ::handleProducts)
        }
    }

    private fun handleProducts(products: List<Product>) {
        products.forEach {
            Log.d(TAG, "handleProducts: $it")
        }
        this.products = products
    }
}