package org.dilarakiraz.composempnotes.data.repository

import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.flow
import org.dilarakiraz.composempnotes.data.api.httpClient
import org.dilarakiraz.composempnotes.data.model.Product

class HomeRepository {
    suspend fun getProductsApi(): List<Product> {
        val response = httpClient.get("https://fakestoreapi.com/products")
        return response.body()
    }

    fun getProducts() = flow {
        emit(getProductsApi())
    }
}